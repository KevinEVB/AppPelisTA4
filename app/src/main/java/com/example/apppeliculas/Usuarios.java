package com.example.apppeliculas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuarios {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String usuarionom;
    private String password;
    private String nombreTitularTarjeta;
    private String numeroTarjeta;
    private String cvv;
    private String fechaExpiracion;

    public Usuarios(String usuarionom, String password, String nombreTitularTarjeta, String numeroTarjeta, String cvv, String fechaExpiracion) {
        this.usuarionom = usuarionom;
        this.password = password;
        this.nombreTitularTarjeta = nombreTitularTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsuarionom() {
        return usuarionom;
    }

    public void setUsuarionom(String usuarionom) {
        this.usuarionom = usuarionom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreTitularTarjeta() {
        return nombreTitularTarjeta;
    }

    public void setNombreTitularTarjeta(String nombreTitularTarjeta) {
        this.nombreTitularTarjeta = nombreTitularTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
