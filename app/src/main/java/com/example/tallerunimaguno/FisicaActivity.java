package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.R.color;

public class FisicaActivity extends AppCompatActivity implements View.OnClickListener{

    Button velocidad, fuerza, voltaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);

        velocidad= findViewById(R.id.fisica_velocidad);
        fuerza= findViewById(R.id.fisica_fuerza);
        voltaje=findViewById(R.id.fisica_voltaje);

        velocidad.setOnClickListener(this);
        fuerza.setOnClickListener(this);
        voltaje.setOnClickListener(this);

        velocidad.setBackgroundColor(Color.rgb(3,169,244));
        fuerza.setBackgroundColor(Color.rgb(3,169,244));



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fisica_velocidad:

                break;
        }
    }
}