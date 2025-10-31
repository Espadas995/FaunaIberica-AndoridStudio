package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class CarnivorosActivity extends AppCompatActivity {
    private RadioButton radioLobo, radioLince, radioGineta, radioZorro, radioNutria;

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

        // las imágenes son INTEGER -> es el codigo int por el que se encuentran con R.drawable (similar a las vistas)
        radioLobo.setOnClickListener(v -> abrirDatos("lobo.txt", R.drawable.lobo));
        radioLince.setOnClickListener(v -> abrirDatos("lince.txt", R.drawable.lince));
        radioGineta.setOnClickListener(v -> abrirDatos("gineta.txt", R.drawable.gineta));
        radioZorro.setOnClickListener(v -> abrirDatos("zorro.txt", R.drawable.zorro));
        radioNutria.setOnClickListener(v -> abrirDatos("nutria.txt", R.drawable.nutria));
    }
}
