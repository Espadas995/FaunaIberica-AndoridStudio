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

        // Cambio de imagenes a ints
        radioAguila.setOnClickListener(v -> abrirDatos("aguila.txt", R.drawable.aguila));
        radioBuho.setOnClickListener(v -> abrirDatos("buho.txt", R.drawable.buho));
        radioHalcon.setOnClickListener(v -> abrirDatos("halcon.txt", R.drawable.halcon));
        radioCernicalo.setOnClickListener(v -> abrirDatos("cernicalo.txt", R.drawable.cernicalo));
        radioQuebrantahuesos.setOnClickListener(v -> abrirDatos("quebrantehuesos.txt", R.drawable.quebrantahuesos));
        radioBuitre.setOnClickListener(v -> abrirDatos("buitre.txt", R.drawable.buitre));
    }

    // COPY-PASTE BRUTAL DESDE CARNIVOROS
    private void abrirDatos(String fichero, int imagen){
        // Comprobar si el fichero existe en assets (actualizado justo debajo: linea 28)
        if (!ficheroExiste(fichero)){
            fichero = "error.txt";
            imagen = R.drawable.oso;
        }

        Intent intent = new Intent(this, DatosActivity.class);
        intent.putExtra("fichero", fichero);
        intent.putExtra("imagen", imagen);
        startActivity(intent);
    }

    // Comprobar si el fichero existe en assets
    private boolean ficheroExiste(String ficheroBuscado){
        try {
            String[] ficheros = getAssets().list("");

            if (ficheros != null) {
                for (String fichero : ficheros){
                    if (fichero.equals(ficheroBuscado)){
                        return true;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
