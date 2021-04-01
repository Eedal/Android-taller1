package com.example.tallerunimaguno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FisicaVelocidad extends AppCompatActivity implements View.OnClickListener{

    EditText distancia, tiempo;
    Button calcular_velocidad;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica_velocidad);

        distancia= findViewById(R.id.distancia);
        tiempo= findViewById(R.id.tiempo);
        calcular_velocidad= findViewById(R.id.calcular_velocidad);

        calcular_velocidad.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calcular_velocidad:
                if (tiempo.getText().toString().equals(0)) {
                    builder= new AlertDialog.Builder(this);
                    builder.setTitle("Error");
                    builder.setMessage("El tiempo no puede ser 0");
                    builder.setPositiveButton("Ok", null);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                } else {
                    double velocidad= Double.parseDouble(distancia.getText().toString())/ Double.parseDouble(tiempo.getText().toString());

                    builder= new AlertDialog.Builder(this);
                    builder.setTitle("Velocidad");
                    builder.setMessage("La velocidad es: "+ velocidad +" m/s");
                    builder.setPositiveButton("Ok", null);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                    velocidad=0;
                    distancia.setText("");
                    tiempo.setText("");
                }
                break;


        }
    }
}