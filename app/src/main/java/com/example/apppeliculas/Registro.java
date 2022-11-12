package com.example.apppeliculas;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    TextInputEditText tieUsuarioR, tiePasswordR, tieNomTarR, tieNumTarR, tieCVV, tieFechadeExp;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        db = FirebaseFirestore.getInstance();

        tieUsuarioR = findViewById(R.id.tieUsuarioR);
        tiePasswordR = findViewById(R.id.tiePasswordR);
        tieNomTarR = findViewById(R.id.tieNomTarR);
        tieNumTarR = findViewById(R.id.tieNumTarR);
        tieCVV = findViewById(R.id.tieCVV);
        tieFechadeExp = findViewById(R.id.tieFechadeExp);
    }

    public void Submit(View view) {

        // Create a new user with a first and last name
        Map<String, Object> usuario = new HashMap<>();
        usuario.put("usuarionom", tieUsuarioR.getText().toString());
        usuario.put("password", tiePasswordR.getText().toString());
        usuario.put("numeroTarjeta", tieNumTarR.getText().toString());
        usuario.put("nombreTitularTarjeta", tieNomTarR.getText().toString());
        usuario.put("fechaExpiracion", tieCVV.getText().toString());
        usuario.put("cvv", tieFechadeExp.getText().toString());


        db.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                        Toast.makeText(Registro.this, "Usuario guardado", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG2", "Error adding document", e);
                    }
                });

// Add a new document with a generated ID
        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete( Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                Log.d("TAG2", document.getId() + " => " + document.get("usuarionom"));
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}