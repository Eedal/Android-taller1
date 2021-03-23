package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import models.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

 EditText usuario, clave;
 Button ingresar, cancelar, register;
 CheckBox termsAndConditions, rememberData;
 public ArrayList<User> Users = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.edtusuario);
        clave = findViewById(R.id.edtclave);
        ingresar = findViewById(R.id.btningresar);
        cancelar = findViewById(R.id.btncancelar);
        register = findViewById(R.id.btnregister);
        termsAndConditions = findViewById(R.id.termsAndConditions);
        rememberData = findViewById(R.id.rememberData);
        ingresar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
        register.setOnClickListener(this);


        //Se encarga de escuchar cuando el check de acepto termino y condiciones lo seleccionan o deseleccionan
        checksBoxListener();


        //Crear un objeto SharePreferences para enseguida que se va creando la vista va colocando los datos, en caso de no
        //existir coloca "Sin valor" en el campo de texto usuario y "" en el campo de texto clave
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        usuario.setText(preferences.getString("user", "Sin valor"));
        clave.setText(preferences.getString("password", ""));

        //Crea n objetos del modelo User con name que se le pase, en este caso Elkin1, Elkin2, Elkin3,... , Elkin(n)
        //y password de igual manera (Elkin1, Elkin2, Elkin3,... ,Elkin(n)

        UsersSeeders(3, "Elkin");

        ArrayList<User> UsersAux = (ArrayList<User>) getIntent().getSerializableExtra("Users");

        if(UsersAux != null){
            this.Users.clear();
            this.Users = UsersAux;
        }
        for (models.User User: Users) {
            Log.d("User", User.getName());
            Log.d("Apellido", User.getLastname());
            Log.d("Passwrod", User.getPassword());

        }

    }

    public void UsersSeeders(Integer units, String name){
        for (int i = 0; i < units ; i++){
            Users.add(new User(name+ String.valueOf(i+1), name+ String.valueOf(i+1), "Prueba", "holasoy@gmail.com"));
        }
    }
    public void checksBoxListener(){
        termsAndConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    ingresar.setEnabled(true);

                else
                    ingresar.setEnabled(false);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean login(String user, String password){
        boolean response = false;
        for (models.User User: Users)
            if(User.getName().equals(user) && User.getPassword().equals(password))
                response = true;

        return response;
    }

    public void rememberData(){
        SharedPreferences preferencias = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("user", usuario.getText().toString());
        editor.putString("password", clave.getText().toString());
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        //Si se seleccionó lo de recordar datos
        if(rememberData.isChecked())
            rememberData();

        switch(v.getId()){
            case R.id.btningresar :

               if(usuario.getText().toString().isEmpty() || clave.getText().toString().isEmpty()){
                   Toast.makeText(getApplicationContext(), "Ambos datos son obligatorios para ingresar", Toast.LENGTH_LONG).show();
               }else if( login( usuario.getText().toString(), clave.getText().toString() ) ){
                   Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                   startActivity(i);
               }else{
                   Toast.makeText(getApplicationContext(), "Error credenciales", Toast.LENGTH_LONG).show();
               }

               break;

            case R.id.btncancelar:

                usuario.setText("");

                clave.setText("");

                //agregar lo de limpiar los checks

                break;

            case R.id.btnregister:

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

                try {
                    intent.putExtra("Users", Users);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

                }
                startActivity(intent);

                break;

        }

    }



}