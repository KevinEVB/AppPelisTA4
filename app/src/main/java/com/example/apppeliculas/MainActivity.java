package com.example.apppeliculas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity{

    FirebaseFirestore db;
    FirebaseAuth mAuth;
    TextView tvRegistrarse;
    TextInputEditText tieUsuario, tiePassword;
    Button btnLogin;
    ProgressBar pB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        tvRegistrarse = findViewById(R.id.tvRegistrarse);
        tieUsuario = findViewById(R.id.tieUsuario);
        tiePassword = findViewById(R.id.tiePassword);
        btnLogin = findViewById(R.id.btnLogin);


        String text = "Registrarse";


        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 0,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvRegistrarse.setText(ss);
        tvRegistrarse.setLinkTextColor(Color.parseColor("#FF3700B3"));
        tvRegistrarse.setMovementMethod(LinkMovementMethod.getInstance());

    }


    public void Login(View view) {

        String tieUsuarioS = tieUsuario.getText().toString();
        String tiePasswordS = tiePassword.getText().toString();

        if (tieUsuarioS.isEmpty() || tiePasswordS.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            db.collection("usuarios")
                    .whereEqualTo("usuarionom", tieUsuarioS)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                String passwordbd = "";
                                int count = 0;
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    passwordbd = document.get("password").toString();
                                    count++;
                                }
                                if (count != 0 ){
                                    if(tiePasswordS.equals(passwordbd)){
                                        Intent intent = new Intent(MainActivity.this, PeliculasAc.class).putExtra("usuarionom", tieUsuarioS);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(MainActivity.this, "Error de contraseña y/o usuario", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
    }
    }
}