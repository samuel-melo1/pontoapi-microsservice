package com.eletronico.pontoapi.services.Impl;

import com.eletronico.pontoapi.core.exceptions.DataIntegrityException;
import com.eletronico.pontoapi.core.exceptions.ObjectNotFoundException;
import com.eletronico.pontoapi.entrypoint.dto.response.UserDTOResponse;
import com.eletronico.pontoapi.persistence.UserRepository;
import com.eletronico.pontoapi.services.UserService;
import com.eletronico.pontoapi.utils.MapperDTO;
import com.eletronico.pontoapi.core.domain.User;
import com.eletronico.pontoapi.entrypoint.dto.request.UserDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import static com.eletronico.pontoapi.core.enums.DataIntegrityViolationError.CPF_ALREADY_EXIST;
import static com.eletronico.pontoapi.core.enums.DataIntegrityViolationError.EMAIL_ALREADY_EXIST;
import static com.eletronico.pontoapi.core.enums.UserExceptionStatusError.NOT_EXIST;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class.getName());
    @Transactional
    @Override
    public Integer saveUser(UserDTO userDTO) {
        userDTO.setId_user(null);

        validToEmailAndCpf(userDTO);
        User newUser = User.builder()
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .telefone(userDTO.getTelefone())
                .status(true)
                .cpf(userDTO.getCpf())
                .cargo(userDTO.getCargo())
                .departamento(userDTO.getDepartamento())
                .name(userDTO.getName())
                .permissions(userDTO.getPermissions()).build();
        userRepository.save(newUser);
        return newUser.getId_user();
    }
    @Override
    public List<UserDTO> findAll(Integer page, Integer pageSize) {
        return MapperDTO.parseListObjects(
                userRepository.findAll(PageRequest.of(page, pageSize)).toList(), UserDTO.class);
    }
    @Override
    public Optional<UserDTO> findByEmail(String email) {
        var userExist = Optional.ofNullable(userRepository.findUserByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException(NOT_EXIST)));
        return Optional.of(MapperDTO.parseObject(Optional.of(userExist.get()), UserDTO.class));
    }
    @Override
    public Optional<UserDTOResponse> findById(Integer id) {
        var userExist = Optional.ofNullable(userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(NOT_EXIST)));
        return Optional.ofNullable(MapperDTO.parseObject(Optional.of(userExist.get()), UserDTOResponse.class));
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userDTO, Integer id) {
        userDTO.setId_user(id);
      //  Optional<UserDTO> oldUser = findUserById(id);

//        if (!userDTO.getPassword().equals(oldUser.get().getPassword())) {
//            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        }
        validToEmailAndCpf(userDTO);

        User newUser = new User();
        BeanUtils.copyProperties(userDTO, newUser);
        return MapperDTO.parseObject(userRepository.save(newUser), UserDTO.class);
    }
    private void validToEmailAndCpf(UserDTO dto) {
        Optional<User> obj = userRepository.findByCpf(dto.getCpf());
        if (obj.isPresent() && !Objects.equals(obj.get().getId_user(), dto.getId_user())) {
            throw new DataIntegrityException(CPF_ALREADY_EXIST);
        }
        obj = userRepository.findByEmail(dto.getEmail());
        if (obj.isPresent() && !Objects.equals(obj.get().getId_user(), dto.getId_user())) {
            throw new DataIntegrityException(EMAIL_ALREADY_EXIST);
        }
    }
}
