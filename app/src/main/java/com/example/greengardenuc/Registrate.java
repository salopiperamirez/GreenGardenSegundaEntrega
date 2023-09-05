package com.example.greengardenuc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;


public class Registrate extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText Rcorreo;
    private EditText Rcontrasena;
    private EditText confirmarcontrasena;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        mAuth = FirebaseAuth.getInstance();

        Rcorreo = findViewById(R.id.Rcorreo);
        Rcontrasena = findViewById(R.id.Rcontrasena);
        confirmarcontrasena = findViewById(R.id.confirmarcontrasena);



    }


    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void registrarUsuario(View view){
        if(Rcontrasena.getText().toString().equals(confirmarcontrasena.getText().toString())){


            mAuth.createUserWithEmailAndPassword(Rcorreo.getText().toString(), Rcontrasena.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NotNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Usuario creado",Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);

                            } else{
                                Toast.makeText(getApplicationContext(), "Autenticacion Fallida",Toast.LENGTH_SHORT).show();

                            }

                        }
                    });


        } else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

    }



}