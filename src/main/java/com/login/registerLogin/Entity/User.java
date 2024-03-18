package com.login.registerLogin.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "login")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String emaillUsuario;

    @Column(name = "usuario")
    private String nombreUsuario;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;


    public User() {
    }

    public User(Integer id, String emaillUsuario, String nombreUsuario, String contrasena, String tipoUsuario) {
        this.id = id;
        this.emaillUsuario = emaillUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
