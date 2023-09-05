package com.example.greengardenuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaConsejoRiego extends AppCompatActivity {

    private Button btnregresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejo_riego);
        inicializar();
        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consejoriego = new Intent(PantallaConsejoRiego.this, PantallaConsejos.class);
                startActivity(consejoriego);

            }
        });
    }
    private void inicializar(){
        btnregresar = findViewById(R.id.btnregresar);
    }
}