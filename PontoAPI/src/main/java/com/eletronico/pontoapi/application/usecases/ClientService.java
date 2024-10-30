package com.eletronico.pontoapi.application.usecases;

import com.eletronico.pontoapi.config.security.UserSS;
import com.eletronico.pontoapi.infrastructure.persistence.UserRepository;
import com.eletronico.pontoapi.core.exceptions.InvalidJwtAuthenticationException;
import com.eletronico.pontoapi.core.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static com.eletronico.pontoapi.entrypoint.dto.response.InvalidJwtResponseError.EMAIL_OR_PASSWORD_INVALID;
@Service
@Slf4j
public class ClientService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByEmail(username);
        if (user != null) {
            return new UserSS(user.get().getId_user(), user.get().getEmail(), user.get().getPassword(), user.get().getPermissions());
        }
        throw new UsernameNotFoundException("Username " + username + " Not Found!");
    }
}
