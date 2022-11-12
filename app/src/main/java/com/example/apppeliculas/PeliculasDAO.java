package com.example.apppeliculas;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PeliculasDAO {
    @Query("SELECT * FROM peliculas")
    List<Peliculas> getAll();

    @Insert
    void insertAll(Peliculas pelicula);

}
