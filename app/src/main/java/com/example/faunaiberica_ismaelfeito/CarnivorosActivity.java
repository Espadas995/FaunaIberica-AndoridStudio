package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CarnivorosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnivoros);
        setTitle("Carnívoros");

        ListView lv = findViewById(R.id.lvAnimales);
        final String[] animales = new String[] {"Lobo", "Lince", "Oso (sin fichero)"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animales);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String seleccionado = animales[position];
                String fichero;
                String imagen;

                if (position == 0){
                    fichero = "lobo.txt";
                    imagen = "lobo";
                } else if (position == 1) {
                    fichero = "lince.txt";
                    imagen  = "lince";
                } else {
                    fichero = "error.txt";
                    imagen = "oso";
                }
                Intent intent = new Intent(CarnivorosActivity.this, DatosActivity.class);
                intent.putExtra("fichero", fichero);
                intent.putExtra("imagen", imagen);
                startActivity(intent);
            }
        });
    }
}
