package com.example.greengardenuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PantallaConsejoAbono extends AppCompatActivity {

    private Button btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_consejo_abono);
        inicializar();
        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consejoabono = new Intent(PantallaConsejoAbono.this, PantallaConsejos.class);
                startActivity(consejoabono);

            }
        });
    }
    private void inicializar(){
        btnregresar = findViewById(R.id.btnregresar);
    }
}