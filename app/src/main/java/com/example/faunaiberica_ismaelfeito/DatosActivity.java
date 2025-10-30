package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatosActivity extends AppCompatActivity {

    private Button btnAtrasDatos;
    private ImageView imagenAnimal;
    private TextView textoAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        btnAtrasDatos = findViewById(R.id.btnAtrasDatos);
        imagenAnimal = findViewById(R.id.imagenAnimal);
        textoAnimal = findViewById(R.id.textoAnimal);

        // Recoger datos del Intent
        Intent intent = getIntent();
        String fichero = intent.getStringExtra("fichero");
        String imagen = intent.getStringExtra("imagen");

        // Cargar imagen siempre
        int resId = getResources().getIdentifier(imagen, "drawable", getPackageName());
        if (resId != 0) {
            imagenAnimal.setImageResource(resId);
        } else {
            Toast.makeText(this, "Imagen no encontrada", Toast.LENGTH_SHORT).show();
        }

        // Leer archivo de texto del assets, si no existe usar error.txt
        String contenido = leerArchivoSeguro(fichero);
        textoAnimal.setText(contenido);

        // Botón para volver atrás
        btnAtrasDatos.setOnClickListener(v -> finish());
    }

    // Intenta leer el archivo, si falla devuelve error.txt
    private String leerArchivoSeguro(String nombreArchivo) {
        try {
            return leerArchivo(nombreArchivo);
        } catch (IOException e) {
            // Intentar con error.txt
            try {
                return leerArchivo("error.txt");
            } catch (IOException ex) {
                return "Error: información no disponible";
            }
        }
    }

    // Lector de archivo simple
    private String leerArchivo(String nombreArchivo) throws IOException {
        StringBuilder texto = new StringBuilder();
        InputStream is = getAssets().open(nombreArchivo);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String linea;
        while ((linea = br.readLine()) != null) {
            texto.append(linea).append("\n");
        }
        br.close();
        return texto.toString();
    }
}
