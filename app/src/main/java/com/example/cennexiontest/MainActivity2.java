package com.example.cennexiontest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cennexiontest.R;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword, editTextConfirmPassword;
    private Spinner spinnerCity;
    private RadioButton radioButtonOption1, radioButtonOption2;
    private static final String EMAIL_KEY = "email";
    private static final String PASSWORD_KEY = "password";
    private static final String CITY_KEY = "city";
    private static final String OPTION_KEY = "option";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinnerCity = findViewById(R.id.spinnerCity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapter);

        // Initialisation des vues
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        radioButtonOption1 = findViewById(R.id.radioButtonOption1);
        radioButtonOption2 = findViewById(R.id.radioButtonOption2);

        Button button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les données
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                String city = spinnerCity.getSelectedItem().toString();
                String option;
                if (radioButtonOption1.isChecked()) {
                    option = "Option 1";
                } else if (radioButtonOption2.isChecked()) {
                    option = "Option 2";
                } else {
                    option = "Non sélectionné";
                }

                // Validation des champs
                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    // Afficher un message d'erreur
                    Toast.makeText(MainActivity2.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Vérification de la correspondance des mots de passe
                if (!password.equals(confirmPassword)) {
                    // Afficher un message d'erreur
                    Toast.makeText(MainActivity2.this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Appel de la méthode pour insérer les données dans la table "annonce"
                DBconnexion dbHelper = new DBconnexion(MainActivity2.this);
                dbHelper.insertInscription(email, password);

                // Redirection vers l'activité suivante
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
              startActivity(intent);

                // Stocker les données dans la base de données (ici, une simulation)
                // DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity2.this);
                // databaseHelper.insertData(email, password, city, option);

                // Rediriger vers l'interface suivante en passant les données via Intent
                //Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
               // intent.putExtra(EMAIL_KEY, email);
               // intent.putExtra(PASSWORD_KEY, password);
              //  intent.putExtra(CITY_KEY, city);
             //   intent.putExtra(OPTION_KEY, option);
            //   startActivity(intent);
            }
        });
    }
}