package com.example.greengardenuc;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Data_administrator {
    private File file;
    private ModelAgua objAgua;
    private ModelAbono objAbono;

    private int tipoUsuario;


    public Data_administrator(File file){
        this.file = file;
    }



    public Data_administrator(File file, ModelAgua objAgua){
        this.file = file;
        this.objAgua = objAgua;
        tipoUsuario = 0;
    }

    public Data_administrator(File file, ModelAbono objAbono){
        this.file = file;
        this.objAbono = objAbono;
        tipoUsuario = 1;
    }

    public void saveData(){
        try {
            if(!file.exists()) {
                Log.i("MyTag","El archivo no existe");
                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                if (tipoUsuario == 0) {
                    bufferedWriter.write("[{'Cantidad de agua (Litros)':'"+objAgua.getAgua()+"', 'Costo de consumo':'"
                            +objAgua.getConsumoAgua()+"', 'Mes':'"+objAgua.getSpMesAgua()+"'}]");
                }
                else if (tipoUsuario == 1){
                    bufferedWriter.write("[{'Cantidad de abono (Kg)':"+objAbono.getAbono()+"," +
                            " 'Costo de consumo':"+objAbono.getConsumoAbono()+", " +
                            "'Mes':'"+objAbono.getSpMesAbono()+"'}]");
                }
                bufferedWriter.close();
            }
            else {
                Log.i("MyTag", "El archivo ya existe");
                JSONArray jsonData = readData();
                boolean comparacion=validacion(jsonData);
                if (comparacion==true){
                    Log.e("MyTag","El mes ya está registrado, intente otro.");
                }
                else{
                    FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    if (tipoUsuario == 0) {
                        String stringData = jsonData.toString();
                        String stringData_process = stringData.substring(1, stringData.length()-1);
                        String newAgua = "{'Cantidad de agua (Litros)':'"+objAgua.getAgua()+"', 'Costo de consumo':'"
                                +objAgua.getConsumoAgua()+"', 'Mes':'"+objAgua.getSpMesAgua()+"'}";
                        bufferedWriter.write("["+ stringData_process + ", " + newAgua +"]");
                    }
                    else if (tipoUsuario == 1){
                        String stringData = jsonData.toString();
                        String stringData_process = stringData.substring(1, stringData.length()-1);
                        String newElectricidad = "{'Cantidad de abono (Kg)':"+ objAbono.getAbono()+", " +
                                "'Costo de consumo':"+objAbono.getConsumoAbono()+", 'Mes':'"+objAbono.getSpMesAbono()+"'}";
                        bufferedWriter.write("["+stringData_process + ", " + newElectricidad+"]");
                    }
                    bufferedWriter.close();
                }
            }
        }

        catch(Exception ex){
            Log.e("MyTag", ex.toString());
        }
    }
    private boolean validacion(JSONArray jsonData){
        boolean comparacion=false;
        try {
            for (int i = 0; i < jsonData.length(); i++) {
                Log.i("MyTag", jsonData.length() + "");
                JSONObject objJson = jsonData.getJSONObject(i);
                String valida = objJson.getString("Mes");
                if (valida.equals(objAgua.getSpMesAgua())){
                    comparacion=true;
                }
            }
        }
        catch (Exception ex) {
            Log.e("MyTag", ex.toString());
        }
        return comparacion;
    }
    public JSONArray readData(){
        try{
            FileReader fileReader = new FileReader(file.getAbsoluteFile());
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line = bufferReader.readLine();
            bufferReader.close();
            JSONArray dataJson = new JSONArray(line);
            return dataJson;
        }
        catch(Exception ex){
            Log.e("MyTag", ex.toString());
            return null;
        }
    }

}
