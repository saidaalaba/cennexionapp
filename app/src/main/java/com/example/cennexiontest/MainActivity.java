package com.example.cennexiontest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Vérifier les conditions pour une connexion réussie
                if (isValidCredentials(email, password)) {
                    // Rediriger vers l'activité 2

                    startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    // Remplacez "Activity2.class" par votre classe d'activité cible
                    Toast.makeText(MainActivity.this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                } else {
                    // Afficher un message d'erreur
                    Toast.makeText(MainActivity.this, "Email ou mot de passe saisi est incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Méthode pour vérifier les informations d'identification
    private boolean isValidCredentials(String email, String password) {
        // Remplacez cette méthode par votre propre logique de vérification des informations d'identification
        String validEmail = "saida_hadiza@gmail.com";
        String validPassword = "password123";

        return email.equals(validEmail) && password.equals(validPassword);
    }
}