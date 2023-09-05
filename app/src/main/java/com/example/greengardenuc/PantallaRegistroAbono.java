package com.example.greengardenuc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

public class PantallaRegistroAbono extends AppCompatActivity {
    private EditText abono;
    private EditText consumoAbono;
    private Spinner spMesAbono;

    private ModelAbono objAbono;
    private Button btnGuardarAbono;
    private Button btnRegresarAbono;

    private Data_administrator objData;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro_abono);
        inicializar();
        btnGuardarAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion_vacio();
                validacion_formato();
                establecer_datos();
                objData = new Data_administrator(file, objAbono);
                objData.saveData();
                Toast.makeText(PantallaRegistroAbono.this, "Dato registrado", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegresarAbono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegresoAbono=new Intent(PantallaRegistroAbono.this,PantallaCategorias.class);
                startActivity(intentRegresoAbono);
            }
        });
    }

    private void inicializar(){
        abono=findViewById(R.id.txtAbono);
        consumoAbono=findViewById(R.id.txtConsumoAbono);
        spMesAbono=findViewById(R.id.spMesAbono);
        String arrayMes[]={"Seleccione Mes","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
                "Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        ArrayAdapter spiner_mes=new ArrayAdapter(this, android.R.layout.simple_spinner_item , arrayMes);
        spMesAbono.setAdapter(spiner_mes);
        btnGuardarAbono=findViewById(R.id.btnGuardarAbono);
        btnRegresarAbono=findViewById(R.id.btnRegresarAbono);
        objAbono = new ModelAbono();
        file = new File(getFilesDir(), "datosAbono.json");
    }
    private void validacion_vacio(){
        abono=findViewById(R.id.txtAbono);
        String datoReturn=abono.getText().toString();
        consumoAbono=findViewById(R.id.txtConsumoAbono);
        String datoReturn2=consumoAbono.getText().toString();
        if (datoReturn.isEmpty()){
            Toast.makeText(this,"Debe ingrsar el o los datos faltantes",Toast.LENGTH_LONG).show();
        }
        if (datoReturn2.isEmpty()){
            Toast.makeText(this,"Debe ingrsar el o los datos faltantes",Toast.LENGTH_LONG).show();
        }
    }
    private void validacion_formato(){
        String datoReturn=consumoAbono.getText().toString();
        try {
            int num=Integer.parseInt(datoReturn);
        }
        catch (Exception err){
            Toast.makeText(this, "Formato incorrecto", Toast.LENGTH_LONG).show();
        }
    }
    private void establecer_datos(){
        objAbono.setAbono(Double.parseDouble(abono.getText().toString()));
        objAbono.setConsumoAbono(Double.parseDouble(consumoAbono.getText().toString()));
        objAbono.setSpMesAbono(spMesAbono.getSelectedItem().toString());
    }
}