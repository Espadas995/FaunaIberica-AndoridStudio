package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class RapacesActivity extends AppCompatActivity {
    private RadioButton radioAguila, radioHalcon, radioBuho, radioCernicalo, radioQuebrantahuesos, radioBuitre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapaces);
        setTitle("Rapaces y carroñeros");

        radioAguila = findViewById(R.id.radioAguilaImperial);
        radioBuho = findViewById(R.id.radioBuhoReal);
        radioHalcon = findViewById(R.id.radioHalconPeregrino);
        radioCernicalo = findViewById(R.id.radioCernicalo);
        radioQuebrantahuesos = findViewById(R.id.radioQuebrantahuesos);
        radioBuitre = findViewById(R.id.radioBuitreLeonado);

        radioAguila.setOnClickListener(v -> abrirDatos("aguila.txt", "aguila"));
        radioBuho.setOnClickListener(v -> abrirDatos("buho.txt", "buho"));
        radioHalcon.setOnClickListener(v -> abrirDatos("halcon.txt", "halcon"));
        radioCernicalo.setOnClickListener(v -> abrirDatos("cernicalo.txt", "cernicalo"));
        radioQuebrantahuesos.setOnClickListener(v -> abrirDatos("quebrantehuesos.txt", "quebrantahuesos"));
        radioBuitre.setOnClickListener(v -> abrirDatos("buitre.txt", "buitre"));
    }

    private void abrirDatos(String fichero, String imagen){
        try {
            getAssets().open(fichero).close();
        } catch (IOException e) {
            fichero = "error.txt";
        }
        Intent intent = new Intent(RapacesActivity.this, DatosActivity.class);
        intent.putExtra("fichero", fichero);
        intent.putExtra("imagen", imagen);
        startActivity(intent);
    }
}
