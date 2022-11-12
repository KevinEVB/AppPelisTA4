package com.example.apppeliculas;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PeliculasAc extends AppCompatActivity {
    TextView tvBienvendido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        tvBienvendido = findViewById(R.id.tvBienvenido);
        String bienvenido = getIntent().getStringExtra("usuarionom");
        tvBienvendido.setText("Bienvenid@ " + bienvenido);
        tvBienvendido.setTextColor(Color.parseColor("#FF3700B3"));
        tvBienvendido.setTextSize(19);


        List<Peliculas> peliculas = new ArrayList<>();
        peliculas.add(new Peliculas("Asu mare", "1h 40m", "+14", R.drawable.asumare));
        peliculas.add(new Peliculas("Paloma de papel", "1h 33m", "+16", R.drawable.palomadepapel));
        peliculas.add(new Peliculas("Marinera norteña", "40m", "APT", R.drawable.marinera));
        peliculas.add(new Peliculas("Negritos de Huánuco", "1h 10m", "+APT", R.drawable.negritos));

        PeliculasAdapter adapter = new PeliculasAdapter(peliculas, this);
        RecyclerView recyclerView = findViewById(R.id.rvPeliAc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(PeliculasAc.this, "Buscar", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}