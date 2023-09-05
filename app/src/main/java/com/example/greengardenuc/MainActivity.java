package com.example.greengardenuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btnInicio;
    private Button btnregistrarse;
   // private Button btnlibros;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(MainActivity.this, Inicio.class);
                startActivity(inicio);

            }
        });

        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrase = new Intent(MainActivity.this, Registrate.class);
                startActivity(registrase);

            }
        });

        /*btnlibros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrase = new Intent(MainActivity.this, Libros.class);
                startActivity(registrase);

            }
        });*/


    }

    private void inicializar(){
        btnInicio = findViewById(R.id.btnInicio);
        btnregistrarse = findViewById(R.id.btnregistrarse);
        //btnlibros = findViewById(R.id.btnlibros );
    }
}