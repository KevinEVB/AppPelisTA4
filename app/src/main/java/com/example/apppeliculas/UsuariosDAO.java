package com.example.apppeliculas;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
    public interface UsuariosDAO {
        @Query("SELECT * FROM usuarios")
        List<Usuarios> getAll();

        @Insert
        void insertAll(Usuarios usuario);

        @Query("SELECT * FROM usuarios where usuarionom = (:usuarionom) and password = (:password)")
        Usuarios login(String usuarionom,String password);
}
