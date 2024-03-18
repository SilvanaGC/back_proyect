package com.login.registerLogin.DTO;

import jakarta.persistence.*;

import java.io.Serializable;

public class UserDTO {

        private Integer id;

        private String emaillUsuario;

        private String nombreUsuario;

        private String tipoUsuario;


    public UserDTO() {
    }

    public UserDTO(Integer id, String emaillUsuario, String nombreUsuario, String tipoUsuario) {
        this.id = id;
        this.emaillUsuario = emaillUsuario;
        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public String getEmaillUsuario() {
            return emaillUsuario;
        }

        public void setEmaillUsuario(String emaillUsuario) {
            this.emaillUsuario = emaillUsuario;
        }

        public String getTipoUsuario() {
            return tipoUsuario;
        }

        public void setTipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }
    }



