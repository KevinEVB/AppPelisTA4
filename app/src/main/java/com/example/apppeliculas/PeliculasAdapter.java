package com.example.apppeliculas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.ViewHolder> {
    List<Peliculas> datos;
    ArrayList<Peliculas> listadatos;
    ArrayList<Peliculas> listadatosO;
    LayoutInflater layoutInflater;
    Context context;

    public PeliculasAdapter(List<Peliculas> datos, Context context) {
        this.datos = datos;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        listadatos =new ArrayList<>(datos);
        listadatosO = new ArrayList<>();
        listadatosO.addAll(listadatos);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contenido, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.juntarData(datos.get(position), context);
    }

    public void filtrar(String svBuscar){
        int longitud = svBuscar.length();
        if(longitud == 0){
            listadatos.clear();
            listadatos.addAll(listadatosO);
        }else{
            List<Peliculas> coleccion = listadatos.stream()
                    .filter(i -> i.getPeliculanom().toLowerCase().contains(svBuscar.toLowerCase()))
                    .collect(Collectors.toList());
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDuracion;
        ImageView ivPoster;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDuracion = itemView.findViewById(R.id.tvDuracion);
        }

        public void juntarData(Peliculas pelicula, Context context) {
            Glide.with(context).load(pelicula.getImagen()).into(ivPoster);
            tvNombre.setText(pelicula.getPeliculanom());
            tvDuracion.setText(pelicula.getDuracion());
        }
    }
}