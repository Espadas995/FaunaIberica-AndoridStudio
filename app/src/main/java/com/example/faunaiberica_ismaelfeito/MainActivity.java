package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgCategorias;
    private RadioButton rbCarnivoros, rbRapaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgCategorias = findViewById(R.id.rgCategorias);
        rbCarnivoros = findViewById(R.id.rbCarnivoros);
        rbRapaces = findViewById(R.id.rbRapaces);

        rgCategorias.setOnCheckedChangeListener((group, checkedId)->{
            Intent intent = null;

            if (checkedId == R.id.rbCarnivoros)
                intent = new Intent(MainActivity.this, CarnivorosActivity.class);
            else if (checkedId == R.id.rbRapaces)
                intent = new Intent(MainActivity.this, RapacesActivity.class);
            if (intent != null){
                startActivity(intent);
                rgCategorias.clearCheck();
            }
        });
    }
}