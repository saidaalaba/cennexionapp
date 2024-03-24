package com.example.cennexiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity3 extends AppCompatActivity {
    private EditText editTextTitre, editTextTypeContrat, editTextDescription;
    private Spinner spinnerCategorie, spinnerSecteur, spinnerVille;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
         spinnerCategorie = findViewById(R.id.spinnerCategorie);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.categorie, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorie.setAdapter(adapter1);

        spinnerSecteur = findViewById(R.id.spinnerSecteur);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.secteur, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSecteur.setAdapter(adapter2);

         spinnerVille= findViewById(R.id.spinnerVille);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVille.setAdapter(adapter);
        // Initialisation des vues
        editTextTitre = findViewById(R.id.editTextTitre);
        editTextTypeContrat = findViewById(R.id.editTextTypeContrat);

        spinnerCategorie = findViewById(R.id.spinnerCategorie);
        spinnerSecteur = findViewById(R.id.spinnerSecteur);
        spinnerVille = findViewById(R.id.spinnerVille);
        button = findViewById(R.id.button2);

        // Ajout d'un écouteur de clic sur le bouton
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les données saisies
                String titre = editTextTitre.getText().toString();
                String typeContrat = editTextTypeContrat.getText().toString();

                String categorie = spinnerCategorie.getSelectedItem().toString();
                String secteur = spinnerSecteur.getSelectedItem().toString();
                String ville = spinnerVille.getSelectedItem().toString();

                // Insérer les données dans la table "annonce"
                DBconnexion dbHelper = new DBconnexion(MainActivity3.this);
                dbHelper.insertAnnonce(titre, typeContrat, categorie, secteur, ville);

                // Compter le nombre d'annonces dans la ville sélectionnée
                int nombreAnnonces = dbHelper.countAnnoncesByVille(ville);

                // Rediriger vers l'activité suivante avec le nombre d'annonces comptées
                // Rediriger vers MainActivity4 avec le nombre d'annonces comptées et le nom de la ville sélectionnée
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("nombreAnnonces", nombreAnnonces);
                intent.putExtra("ville", ville);
                startActivity(intent);
            }
   });
    }


}