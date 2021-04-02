package com.example.tallerunimaguno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityGeometria extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText x1,y1,x2,y2;
    AlertDialog.Builder builder,builder2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria);

        x1= findViewById(R.id.x1);
        y1=findViewById(R.id.y1);
        x2=findViewById(R.id.x2);
        y2=findViewById(R.id.y2);
        spinner= findViewById(R.id.spinner);

        ArrayAdapter <CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.opciones, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        builder= new AlertDialog.Builder(this);

        if(x1.getText().toString().isEmpty()
                || x2.getText().toString().isEmpty()
                || y1.getText().toString().isEmpty()
                || y2.getText().toString().isEmpty()
        ){
            builder.setTitle("Advertencia");
            builder.setMessage("No puede quedar campos vacios");
            builder.setPositiveButton("Ok", null);
            AlertDialog dialog=builder.create();
            dialog.show();
        }
        if(position==0){

        }
        else {
            if (x1.getText().toString().isEmpty()
                    || x2.getText().toString().isEmpty()
                    || y1.getText().toString().isEmpty()
                    || y2.getText().toString().isEmpty()
            ) {
                builder.setTitle("Advertencia");
                builder.setMessage("No puede quedar campos vacios");
                builder.setPositiveButton("Ok", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            } else {
                double X1 = Double.parseDouble(x1.getText().toString());
                double X2 = Double.parseDouble(x2.getText().toString());
                double Y1 = Double.parseDouble(y1.getText().toString());
                double Y2 = Double.parseDouble(y2.getText().toString());

                if (position == 1) {


                    if (X1 > 0 && Y1 > 0) {
                        builder.setTitle("Cuadrante P1");
                        builder.setMessage("El punto 1 se encuentra en el primer cuadrante");
                        builder.setPositiveButton("Ok", null);
                    } else if (X1 < 0 && Y1 > 0) {
                        builder.setTitle("Cuadrante P1");
                        builder.setMessage("El punto 1 se encuentra en el segundo cuadrante");
                        builder.setPositiveButton("Ok", null);
                    } else if (X1 < 0 && Y1 < 0) {
                        builder.setTitle("Cuadrante P1");
                        builder.setMessage("El punto 1 se encuentra en el tercer cuadrante");
                        builder.setPositiveButton("Ok", null);
                    } else {
                        builder.setTitle("Cuadrante P1");
                        builder.setMessage("El punto 1 se encuentra en el cuarto cuadrante");
                        builder.setPositiveButton("Ok", null);
                    }
                    if (X2 > 0 && Y2 > 0) {
                        builder2.setTitle("Cuadrante P2");
                        builder2.setMessage("El punto 2 se encuentra en el primer cuadrante");
                        builder2.setPositiveButton("Ok", null);
                    } else if (X2 < 0 && Y2 > 0) {
                        builder2.setTitle("Cuadrante P2");
                        builder2.setMessage("El punto 2 se encuentra en el segundo cuadrante");
                        builder2.setPositiveButton("Ok", null);
                    } else if (X2 < 0 && Y2 < 0) {
                        builder2.setTitle("Cuadrante P2");
                        builder2.setMessage("El punto 2 se encuentra en el tercer cuadrante");
                        builder2.setPositiveButton("Ok", null);
                    } else {
                        builder2.setTitle("Cuadrante P2");
                        builder2.setMessage("El punto 2 se encuentra en el cuarto cuadrante");
                        builder2.setPositiveButton("Ok", null);
                    }
                    AlertDialog dialog1 = builder.create();
                    AlertDialog dialog2= builder2.create();
                    dialog1.show();
                    dialog2.show();


                }
                if (position == 2) {

                    double denominador = (X2 - X1);

                    if (denominador != 0) {
                        double pendiente = (Y2 - Y1) / (X2 - X1);
                        builder.setTitle("Pendiente");
                        builder.setMessage("La pendiente es: " + pendiente);
                        builder.setPositiveButton("Ok", null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
                if (position == 3) {

                    double distancia = Math.sqrt(Math.pow((X2 - X1), 2) + Math.pow((Y2 - Y1), 2));
                    builder.setTitle("Distancia");
                    builder.setMessage("La distancia entre los puntos P1 Y P2 es: " + distancia);
                    builder.setPositiveButton("Ok", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }
        }





    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(), "Nada seleecionado", Toast.LENGTH_SHORT).show();
    }
}