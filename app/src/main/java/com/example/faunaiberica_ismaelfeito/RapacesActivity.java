package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class RapacesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapaces);
        setTitle("Rapaces y carroñeros");

        ListView lv = findViewById(R.id.lvAnimales);
        final String[] animales = new String[] {"Águila", "Halcón"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, animales);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fichero;
                String imagen;
                if (position == 0){
                    fichero = "aguila.txt";
                    imagen = "aguila";
                }else {
                    fichero = "halcon.txt";
                    imagen = "halcon";
                }
                Intent intent = new Intent(RapacesActivity.this, DatosActivity.class);
                intent.putExtra("fichero", fichero);
                intent.putExtra("imagen", imagen);
                startActivity(intent);
            }
        });
    }
}
