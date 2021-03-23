package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import controllers.UserController;
import models.User;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user, password;
    Button back, register;
    ArrayList<User> Users = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        back = findViewById(R.id.btnBack);
        register = findViewById(R.id.btnRegister);
        back.setOnClickListener(this);
        register.setOnClickListener(this);
        this.Users = (ArrayList<User>) getIntent().getSerializableExtra("Users");

    }
    public boolean existUser(String user){
        boolean response = false;
        for (models.User User: Users)
            if(User.getName().equals(user))
                response = true;

        return response;
    }
    @Override
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.btnBack:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                try {
                    i.putExtra("Users", Users);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

                }
                startActivity(i);
                break;

            case R.id.btnRegister:

                if(user.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Ambos datos son obligatorios para ingresar", Toast.LENGTH_LONG).show();
                }else if (password.getText().toString().length() < 6){
                    Toast.makeText(getApplicationContext(), "La contraseña debe ser minimo de 6 caracteres", Toast.LENGTH_LONG).show();
                }else if(existUser(user.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Este usuario ya se encuentra registrado", Toast.LENGTH_LONG).show();
                }else{
                    this.Users.add(UserController.store(user.getText().toString(), password.getText().toString()));
                    Toast.makeText(getApplicationContext(), "Usuario registrado con exito", Toast.LENGTH_LONG).show();
                }
                break;

        }
    }

}