package com.example.faunaiberica_ismaelfeito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

        rbCarnivoros = findViewById(R.id.rbCarnivoros);
        rbRapaces = findViewById(R.id.rbRapaces);

        rbCarnivoros.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CarnivorosActivity.class);
            startActivity(intent);
            rbCarnivoros.setChecked(false);
        });

        rbRapaces.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RapacesActivity.class);
            startActivity(intent);
            rbRapaces.setChecked(false);
        });
    }
}