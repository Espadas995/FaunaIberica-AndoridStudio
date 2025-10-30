package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class CarnivorosActivity extends AppCompatActivity {
    private RadioButton radioLobo, radioLince, radioGineta, radioZorro, radioNutria;

    private void abrirDatos(String fichero, String imagen){
        // Comprobar si el fichero existe en assets
        try {
            getAssets().open(fichero).close(); // intenta abrirlo y cerrar inmediatamente
        } catch (IOException ex) {
            fichero = "error.txt"; // fallback si no existe
        }

        Intent intent = new Intent(CarnivorosActivity.this, DatosActivity.class);
        intent.putExtra("fichero", fichero);
        intent.putExtra("imagen", imagen);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnivoros);
        setTitle("Carnívoros");

        radioLobo = findViewById(R.id.radioLobo);
        radioLince = findViewById(R.id.radioLince);
        radioGineta = findViewById(R.id.radioGineta);
        radioZorro = findViewById(R.id.radioZorro);
        radioNutria = findViewById(R.id.radioNutria);

        radioLobo.setOnClickListener(v -> abrirDatos("lobo.txt", "lobo"));
        radioLince.setOnClickListener(v -> abrirDatos("lince.txt", "lince"));
        radioGineta.setOnClickListener(v -> abrirDatos("gineta.txt", "gineta"));
        radioZorro.setOnClickListener(v -> abrirDatos("zorro.txt", "zorro"));
        radioNutria.setOnClickListener(v -> abrirDatos("nutria.txt", "nutria"));
    }
}
