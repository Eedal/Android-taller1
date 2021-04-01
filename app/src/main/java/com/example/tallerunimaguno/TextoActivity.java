package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class TextoActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editar_texto;
    CheckBox negrita, subrayada, italica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        editar_texto= findViewById(R.id.editar_texto);

        negrita= findViewById(R.id.negrita);
        subrayada= findViewById(R.id.subrayada);
        italica= findViewById(R.id.italica);


        NegritaListenerChecked();
        ItalicaListenerChecked();
        SubrayadaListenerChecked();

    }



    public void NegritaListenerChecked(){
        negrita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editar_texto.setTypeface(null, Typeface.BOLD);
                    editar_texto.setText(editar_texto.getText().toString());
                }
                else{
                    editar_texto.setTypeface(null,Typeface.NORMAL);
                    editar_texto.setText(editar_texto.getText().toString());
                }
            }
        });

    }

    public void ItalicaListenerChecked(){
        italica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editar_texto.setTypeface(null, Typeface.ITALIC);
                    editar_texto.setText(editar_texto.getText().toString());
                }
                else{
                    editar_texto.setTypeface(null,Typeface.NORMAL);
                    editar_texto.setText(editar_texto.getText().toString());
                }
            }
        });

    }

    public void SubrayadaListenerChecked(){
        subrayada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    SpannableString texto_subrayado= new SpannableString(editar_texto.getText().toString());
                    texto_subrayado.setSpan(new UnderlineSpan(),0, texto_subrayado.length(), 0);
                    editar_texto.setText(texto_subrayado);

                }
                else{
                    editar_texto.setTypeface(null,Typeface.NORMAL);
                    editar_texto.setText(editar_texto.getText().toString());
                }
            }
        });

    }
    @Override
    public void onClick(View v) {

    }


}