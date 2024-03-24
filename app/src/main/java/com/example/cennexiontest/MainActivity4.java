package com.example.cennexiontest;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);

            // Récupérer le nombre d'annonces comptées depuis l'Intent
            int nombreAnnonces = getIntent().getIntExtra("nombreAnnonces", 0);
            String ville = getIntent().getStringExtra("ville");

            // Afficher le nombre d'annonces comptées (par exemple, dans un TextView)
            TextView textViewNombreAnnonces = findViewById(R.id.textView14);
            textViewNombreAnnonces.setText("il y'a acctuellment " + nombreAnnonces+"annonce(s) sur "+ville);
        }
    }

