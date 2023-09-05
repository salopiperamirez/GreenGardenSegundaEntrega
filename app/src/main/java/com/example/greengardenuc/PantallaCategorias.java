package com.example.greengardenuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaCategorias extends AppCompatActivity {

    private Button btnAbono;
    private Button btnAgua;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_categorias);
        inicializar();
        btnAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbono=new Intent(PantallaCategorias.this, PantallaRegistroAbono.class);
                startActivity(intentAbono);

            }
        });
        btnAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAgua=new Intent(PantallaCategorias.this,PantallaRegistroAgua.class);
                startActivity(intentAgua);

            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegresar=new Intent(PantallaCategorias.this, PantallaPefil.class);
                startActivity(intentRegresar);
            }
        });
    }
    private void inicializar(){
        btnAbono=findViewById(R.id.botonPantallaAbono);
        btnAgua=findViewById(R.id.botonPantallaAgua);
        btnRegresar=findViewById(R.id.btnRegresarCategorias);
    }
}