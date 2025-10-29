package com.example.faunaiberica_ismaelfeito;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DatosActivity extends AppCompatActivity {
    private TextView tvDatos;
    private ImageView ivAnimal;

    private String readAssetText(String filename) throws IOException{
        AssetManager am = getAssets();
        InputStream is = am.open(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null){
            sb.append(line).append('\n');
        }
        return sb.toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        tvDatos = findViewById(R.id.tvDatosAnimal);
        ivAnimal = findViewById(R.id.ivAnimal);

        String fichero = getIntent().getStringExtra("fichero");
        String imagenNombre = getIntent().getStringExtra("imagen");
        if (fichero == null)
            fichero = "error.txt";
        if (imagenNombre == null)
            imagenNombre = "oso";

        String contenido;
        boolean fileOk = true;
        try{
            contenido = readAssetText(fichero);
        } catch (IOException e) {
            fileOk = false;
            try {
                contenido = readAssetText("error.txt");
            } catch (IOException e2){
                contenido = "Error inesperado al cargar los datos del animal";
            }
            imagenNombre = "oso";
        }

        tvDatos.setText(contenido);

        int resId = getResources().getIdentifier(imagenNombre, "drawable", getPackageName());
        if (resId == 0){
            resId = getResources().getIdentifier("oso", "drawable", getPackageName());
        }
        ivAnimal.setImageResource(resId);

        if (fileOk)
            setTitle("Datos");
        else
            setTitle("Datos (sin fichero)");
    }
}
