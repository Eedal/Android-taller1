package com.example.tallerunimaguno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import controllers.UserController;
import models.User;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user, password, lastname, email, username;
    RadioButton masculino, femenino;
    Button back, register;
    AlertDialog.Builder builder_exito, builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username= findViewById(R.id.username);
        user = findViewById(R.id.user);
        lastname= findViewById(R.id.lastname);
        email= findViewById(R.id.email);
        password = findViewById(R.id.password);
        back = findViewById(R.id.btnBack);
        register = findViewById(R.id.btnRegister);

        masculino= (RadioButton) findViewById(R.id.masculino);
        femenino= (RadioButton) findViewById(R.id.femenino);

        back.setOnClickListener(this);
        register.setOnClickListener(this);



    }
    public boolean existUser(String user){
        boolean response = false;
        for (models.User User: GlobalData.Users)
            if(User.getName().equals(user))
                response = true;

        return response;
    }
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btnBack:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(i);
                break;

            case R.id.btnRegister:

                if(user.getText().toString().isEmpty()
                        || username.getText().toString().isEmpty()
                        || password.getText().toString().isEmpty()
                        || lastname.getText().toString().isEmpty()
                        || email.getText().toString().isEmpty()

                ){
                    builder= new AlertDialog.Builder(this);
                    builder.setTitle("Error credenciales");
                    builder.setMessage("No puede quedar campos vacios");
                    builder.setPositiveButton("Ok", null);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }else if (password.getText().toString().length() < 6){
                    builder= new AlertDialog.Builder(this);
                    builder.setTitle("Error");
                    builder.setMessage("La contraseña debe ser de al menos 6 caracteres");
                    builder.setPositiveButton("Ok", null);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }else if(existUser(user.getText().toString())){
                    builder= new AlertDialog.Builder(this);
                    builder.setTitle("Atención");
                    builder.setMessage("Este usuario ya se encuentra registrado");
                    builder.setPositiveButton("Ok", null);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }else{
                    String sexo="";
                    if(masculino.isChecked()){
                        sexo="Masculino";
                    }
                    if(femenino.isChecked()){
                        sexo="Femenino";
                    }
                    GlobalData.Users.add(UserController.store(user.getText().toString(), password.getText().toString(), lastname.getText().toString(), email.getText().toString(), sexo));
                    builder_exito= new AlertDialog.Builder(this);
                    builder_exito.setTitle("Atención");
                    builder_exito.setMessage("Registo exitoso");
                    builder_exito.setPositiveButton("Ok", null);
                    AlertDialog dialog_exito=builder_exito.create();
                    dialog_exito.show();
                    user.setText("");
                    username.setText("");
                    password.setText("");
                    lastname.setText("");
                    email.setText("");
                    sexo="";
                    masculino.setChecked(false);
                    femenino.setChecked(false);
                }
                break;

        }
    }



}