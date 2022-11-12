package com.example.apppeliculas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Peliculas {
    @PrimaryKey(autoGenerate = true)
    private int pid;

    private String peliculanom;
    private String duracion;
    private String restriccion;
    private int imagen;

    public Peliculas(String peliculanom, String duracion, String restriccion, int imagen) {
        this.peliculanom = peliculanom;
        this.duracion = duracion;
        this.restriccion = restriccion;
        this.imagen = imagen;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPeliculanom() {
        return peliculanom;
    }

    public void setPeliculanom(String peliculanom) {
        this.peliculanom = peliculanom;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(String restriccion) {
        this.restriccion = restriccion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}