package com.example.greengardenuc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ModelAbono extends AppCompatActivity {

    private double abono;
    private double consumoAbono;
    private String spMesAbono;
    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getConsumoAbono() {
        return consumoAbono;
    }

    public void setConsumoAbono(double consumoAbono) {
        this.consumoAbono = consumoAbono;
    }

    public String getSpMesAbono() {
        return spMesAbono;
    }

    public void setSpMesAbono(String spMesAbono) {
        this.spMesAbono = spMesAbono;
    }

}