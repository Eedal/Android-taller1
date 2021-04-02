package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import controllers.UserController;
import models.User;

public class RestablacerPassActivity extends AppCompatActivity implements View.OnClickListener {
    String code;
    User user;
    EditText newPass, newPass2;
    Button restablacer_pass;
    public User findCode(){
        User response = null;
        for (models.User User: GlobalData.Users){
            if(User.getCode().compareTo(this.code) == 0){

                response = User;

            }
        }

        return response;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restablacer_pass);
        this.code = getIntent().getExtras().getString("code");
        if(findCode() != null){
            this.user = findCode();
        }
        newPass = findViewById(R.id.new_pass);
        newPass2 = findViewById(R.id.new_pass2);
        restablacer_pass = findViewById(R.id.btn_restablacer_pass);
        restablacer_pass.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_restablacer_pass:
                    if (newPass.getText().toString().compareTo(newPass2.getText().toString()) == 0){
                        User userAux = UserController.store(this.user.getUsername(), this.user.getName(), newPass.getText().toString(), this.user.getLastname(), this.user.getEmail(), this.user.getSexo(), "");
                        Log.d("code aux", userAux.getName() + " " +userAux.getPassword() + GlobalData.Users.size());

                        GlobalData.Users.add(userAux);
                        Log.d("code aux", userAux.getName() + " " +userAux.getPassword() + GlobalData.Users.size());
                        GlobalData.Users.remove(this.user);
                        Log.d("code aux", userAux.getName() + " " +userAux.getPassword() + GlobalData.Users.size());

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }else
                        Toast.makeText(getApplicationContext(), "Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}