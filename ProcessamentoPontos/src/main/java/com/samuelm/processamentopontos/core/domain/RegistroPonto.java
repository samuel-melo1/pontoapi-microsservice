package com.samuelm.processamentopontos.core.domain;

import enums.TipoRegistroPonto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class RegistroPonto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ponto;

    private LocalDate dateRegister;
    private LocalTime hourRegister;
    private String currentLocation;
    private Integer id_user;
    private LocalDateTime dateUpdate;
    private TipoRegistroPonto type;
    public RegistroPonto() {
    }

    public RegistroPonto(Long id_ponto, LocalDate dateRegister, LocalTime hourRegister, String currentLocation, Integer id_user, LocalDateTime dateUpdate, TipoRegistroPonto type) {
        this.id_ponto = id_ponto;
        this.dateRegister = dateRegister;
        this.hourRegister = hourRegister;
        this.currentLocation = currentLocation;
        this.id_user = id_user;
        this.dateUpdate = dateUpdate;
        this.type = type;
    }

    public Long getId_ponto() {
        return id_ponto;
    }

    public void setId_ponto(Long id_ponto) {
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
    public String toString() {
        return "RegistroPonto{" +
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
