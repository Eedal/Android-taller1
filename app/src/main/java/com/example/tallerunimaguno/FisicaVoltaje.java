package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FisicaVoltaje extends AppCompatActivity  implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    Button calcularVoltaje;
    CheckBox checkBoxR1;
    EditText amperaje, resistencia1, resistencia2, resistencia3;
    String option ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica_voltaje);
        try{
            checkBoxR1 = findViewById(R.id.checkBoxR1);
            amperaje = findViewById(R.id.txt_amperaje);
            resistencia1 = findViewById(R.id.txt_r1);
            resistencia2 = findViewById(R.id.txt_r2);
            resistencia3 = findViewById(R.id.txt_r3);
            calcularVoltaje = findViewById(R.id.calcularVoltaje);
            calcularVoltaje.setOnClickListener(this);

            Spinner spinner = findViewById(R.id.spinnerVoltaje);

            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.circuitsOptions, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }catch (Exception e){
            Log.d("error", String.valueOf(e));
            super.onPause();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calcularVoltaje:
                Integer amp = Integer.parseInt(amperaje.getText().toString());
                Integer r1 = Integer.parseInt(resistencia1.getText().toString());
                Integer r2 = Integer.parseInt(resistencia2.getText().toString());
                Integer r3 = 0;
                if(this.option.compareTo("3") == 0){
                    r3 = Integer.parseInt(resistencia2.getText().toString());
                }
                Integer resultado;
                if(checkBoxR1.isChecked()){


                    resultado = amp * (r1 + r2 + r3);

                    Toast.makeText(getApplicationContext(),String.valueOf(resultado), Toast.LENGTH_SHORT).show();

                }else{
                    if(this.option.compareTo("3") == 0){
                        if(r1 == 0 || r2 == 0 || r3==0){
                            Toast.makeText(getApplicationContext(),"Las resistencias no pueden ser cero", Toast.LENGTH_SHORT).show();

                        }else {
                            resultado = amp/r1 + amp/r2 + amp/r3;

                            Toast.makeText(getApplicationContext(),String.valueOf(resultado), Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        if(r1 == 0 || r2 == 0){
                            Toast.makeText(getApplicationContext(),"Las resistencias no pueden ser cero", Toast.LENGTH_SHORT).show();

                        }else{
                            resultado = amp/r1 + amp/r2;

                            Toast.makeText(getApplicationContext(),String.valueOf(resultado), Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.option = parent.getItemAtPosition(position).toString();
        findViewById(R.id.textView35).setVisibility(View.VISIBLE);
        findViewById(R.id.txt_r1).setVisibility(View.VISIBLE);
        findViewById(R.id.checkBoxR1).setVisibility(View.VISIBLE);

        findViewById(R.id.textView36).setVisibility(View.VISIBLE);
        findViewById(R.id.txt_r2).setVisibility(View.VISIBLE);


        if(this.option.compareTo("2") == 0){
            //muestra 2
            findViewById(R.id.textView37).setVisibility(View.INVISIBLE);
            findViewById(R.id.txt_r3).setVisibility(View.INVISIBLE);


            Toast.makeText(getApplicationContext(), option, Toast.LENGTH_SHORT).show();
        }else if(this.option.compareTo("3") == 0){
            findViewById(R.id.textView37).setVisibility(View.VISIBLE);
            findViewById(R.id.txt_r3).setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}