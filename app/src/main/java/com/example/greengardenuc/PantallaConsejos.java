package com.example.greengardenuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PantallaConsejos extends AppCompatActivity {

    private Button btnRiego;
    private Button btnEnergia;
    private Button btnAbono;
    private Button btnregresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejos);
        inicializar();
       btnRiego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consejoriego = new Intent(PantallaConsejos.this, PantallaConsejoRiego.class);
                startActivity(consejoriego);
            }
        });
        btnEnergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consejoenergia = new Intent(PantallaConsejos.this, PantallaConsejoEnergia.class);
                startActivity(consejoenergia);
            }
        });

        btnAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consejoabono = new Intent(PantallaConsejos.this, PantallaConsejoAbono.class);
                startActivity(consejoabono);

            }
        });
        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regresar = new Intent(PantallaConsejos.this, PantallaPefil.class);
                startActivity(regresar);

            }
        });
    }
    private void inicializar(){
        btnRiego = findViewById(R.id.btnRiegoConsejos);
        btnEnergia = findViewById(R.id.btnEnergiaConsejos);
        btnAbono = findViewById(R.id.btnAbonoConsejos);
        btnregresar=findViewById(R.id.btnregresar);
    }
}