package dtos;

import enums.TipoRegistroPonto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class RegistroPontoDTO implements Serializable {

    private Integer id_ponto;
    private LocalDate dateRegister = LocalDate.now();
    private LocalTime hourRegister = LocalTime.now();

    private String currentLocation;
    private Integer id_user;
    private LocalDateTime dateUpdate;
    private TipoRegistroPonto type;

    public RegistroPontoDTO() {
    }

    public RegistroPontoDTO(Integer id_ponto, LocalDate dateRegister,LocalTime hourRegister, String currentLocation, Integer id_user, LocalDateTime dateUpdate, TipoRegistroPonto type) {
        this.id_ponto = id_ponto;
        this.dateRegister = LocalDate.now();
        this.hourRegister = LocalTime.now();
        this.currentLocation = currentLocation;
        this.id_user = id_user;
        this.dateUpdate = dateUpdate;
        this.type = type;
    }


    public Integer getId_ponto() {
        return id_ponto;
    }

    public void setId_ponto(Integer id_ponto) {
        this.id_ponto = id_ponto;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public LocalTime getHourRegister() {
        return hourRegister;
    }

    public void setHourRegister(LocalTime hourRegister) {
        this.hourRegister = hourRegister;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public TipoRegistroPonto getType() {
        return type;
    }

    public void setType(TipoRegistroPonto type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroPontoDTO that = (RegistroPontoDTO) o;
        return Objects.equals(getId_ponto(), that.getId_ponto()) && Objects.equals(getId_user(), that.getId_user());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_ponto(), getId_user());
    }

    @Override
    public String toString() {
        return "RegistroPontoDTO{" +
                "id_ponto=" + id_ponto +
                ", dateRegister=" + dateRegister +
                ", hourRegister=" + hourRegister +
                ", currentLocation='" + currentLocation + '\'' +
                ", id_user=" + id_user +
                ", dateUpdate=" + dateUpdate +
                ", type=" + type +
                '}';
    }
}