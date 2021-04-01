package com.example.tallerunimaguno;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button matematicas;
    Button ayuda, cerrar_sesion, fisica, geometria, texto;
    AlertDialog.Builder builder_ayuda, builder_cerrar_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        matematicas = findViewById(R.id.btnmatematicas);
        ayuda= findViewById(R.id.btn_ayuda);
        cerrar_sesion= findViewById(R.id.btn_cerrar_sesion);
        fisica= findViewById(R.id.btnfisica);
        geometria= findViewById(R.id.btngeometria);
        texto= findViewById(R.id.btntexto);
        matematicas.setOnClickListener(this);
        ayuda.setOnClickListener(this);
        cerrar_sesion.setOnClickListener(this);
        fisica.setOnClickListener(this);
        geometria.setOnClickListener(this);
        texto.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.mnugeometria:
            //    Toast.makeText(getApplicationContext(), "MENU GEOMETRIA", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(),ActivityGeometria.class);
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.btnmatematicas:
                i = new Intent(getApplicationContext(),MatematicasActivity.class);
                startActivity(i);
                break;
            case R.id.btnfisica:

                i = new Intent(getApplicationContext(),FisicaActivity.class);
                startActivity(i);
                break;
            case R.id.btntexto:
                i = new Intent(getApplicationContext(),TextoActivity.class);
                startActivity(i);
                break;
            case R.id.btngeometria:
                i = new Intent(getApplicationContext(),ActivityGeometria.class);
                startActivity(i);
                break;
            case R.id.btn_ayuda:
                builder_ayuda= new AlertDialog.Builder(this);
                builder_ayuda.setTitle("Ayuda");
                builder_ayuda.setMessage("App V1: \n Realizado por: Elkin de armas, Alex Ortega");
                builder_ayuda.setPositiveButton("Ok", null);
                builder_ayuda.setNegativeButton("Cancel", null);
                AlertDialog dialog_ayuda=builder_ayuda.create();
                dialog_ayuda.show();
                break;

            case R.id.btn_cerrar_sesion:
                builder_cerrar_sesion= new AlertDialog.Builder(this);
                builder_cerrar_sesion.setTitle("Atención");
                builder_cerrar_sesion.setMessage("¿Desea cerrar sesion?");

                builder_cerrar_sesion.setPositiveButton("Cancel", null);
                builder_cerrar_sesion.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i=  new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
                AlertDialog dialog_sesion=builder_cerrar_sesion.create();
                dialog_sesion.show();
                break;



        }
    }
}