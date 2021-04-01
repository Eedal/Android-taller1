package com.example.tallerunimaguno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FisicaFuerza extends AppCompatActivity implements View.OnClickListener{
    EditText masa, aceleracion;
    Button calcular_fuerza;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica_fuerza);

        masa= findViewById(R.id.masa);
        aceleracion= findViewById(R.id.aceleracion);
        calcular_fuerza= findViewById(R.id.calcular_fuerza);

        calcular_fuerza.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calcular_fuerza:
                double fuerza= Double.parseDouble(masa.getText().toString()) * Double.parseDouble(aceleracion.getText().toString());
                builder= new AlertDialog.Builder(this);
                builder.setTitle("Velocidad");
                builder.setMessage("La fuerza es: "+ fuerza +" N");
                builder.setPositiveButton("Ok", null);
                AlertDialog dialog=builder.create();
                dialog.show();
                fuerza=0;
                aceleracion.setText("");
                masa.setText("");
        }
    }
}