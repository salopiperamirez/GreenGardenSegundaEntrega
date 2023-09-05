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

public class PantallaRegistroAgua extends AppCompatActivity {

    private EditText agua;
    private EditText consumoAgua;
    private Spinner spMesAgua;
    private ModelAgua objAgua;
    private Button btnGuardarAgua;
    private Button btnRegresarAgua;
    private Data_administrator objData;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro_agua);
        inicializar();
        btnGuardarAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validacion_vacio();
                validacion_formato();
                establecer_datos();
                objData = new Data_administrator(file, objAgua);
                objData.saveData();
                Toast.makeText(PantallaRegistroAgua.this, "Dato registrado", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegresarAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegresoAgua=new Intent(PantallaRegistroAgua.this,PantallaCategorias.class);
                startActivity(intentRegresoAgua);
            }
        });
    }
    private void inicializar(){
        agua=findViewById(R.id.txtAgua);
        consumoAgua=findViewById(R.id.txtConsumoAgua);
        spMesAgua=findViewById(R.id.spMesAgua);
        String arrayMes[]={"Seleccione Mes","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",
                "Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        ArrayAdapter spiner_mes=new ArrayAdapter(this, android.R.layout.simple_spinner_item , arrayMes);
        spMesAgua.setAdapter(spiner_mes);
        btnGuardarAgua=findViewById(R.id.btnGuardarAgua);
        btnRegresarAgua=findViewById(R.id.btnRegresarAgua);
        objAgua = new ModelAgua();
        file = new File(getFilesDir(), "datosAgua.json");
    }
    private void validacion_vacio(){
        agua=findViewById(R.id.txtAgua);
        String datoReturn=agua.getText().toString();
        consumoAgua=findViewById(R.id.txtConsumoAgua);
        String datoReturn2=consumoAgua.getText().toString();
        if (datoReturn.isEmpty()){
            Toast.makeText(this,"Debe ingrsar el o los datos faltantes",Toast.LENGTH_LONG).show();
        }
        if (datoReturn2.isEmpty()){
            Toast.makeText(this,"Debe ingrsar el o los datos faltantes",Toast.LENGTH_LONG).show();
        }
    }
    private void validacion_formato(){
        String datoReturn=consumoAgua.getText().toString();
        try {
            int num=Integer.parseInt(datoReturn);
        }
        catch (Exception err){
            Toast.makeText(this, "Formato incorrecto", Toast.LENGTH_LONG).show();
        }
    }
    private void establecer_datos(){
        objAgua.setAgua(Double.parseDouble(agua.getText().toString()));
        objAgua.setConsumoAgua(Double.parseDouble(consumoAgua.getText().toString()));
        objAgua.setSpMesAgua(spMesAgua.getSelectedItem().toString());
    }
}