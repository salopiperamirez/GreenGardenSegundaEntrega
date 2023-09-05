package com.example.greengardenuc;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import android.content.DialogInterface;

import java.util.ArrayList;

public class Libros extends AppCompatActivity {

    private ListView listView;

    private ArrayList <String> libros;

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);

        listView = findViewById(R.id.listviewlibros);
        libros = new ArrayList<>();

        //Inicializacion del objeto en Firebase Storage
        mStorageRef = FirebaseStorage.getInstance().getReference();

        //Se trae los libros en PDF de Firebase
        StorageReference ref = mStorageRef.child("libros");

        // Codigo para traer los libros
        ref.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {

            @Override
            public void onSuccess(ListResult listResult) {
                for (StorageReference item: listResult.getItems()){
                    libros.add(item.getName() + "");
                }


                //configuro el adapatador de la lista
                ArrayAdapter <String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, libros);

                //muestro el adaptadpr
                listView.setAdapter(adapter);

            }


        });




    }
}






