package com.example.tallerunimaguno;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import controllers.UserController;
import models.User;

public class ForgotPassActivity extends AppCompatActivity implements View.OnClickListener{
    Button validate_code, send_code;
    EditText txt_correo, txt_code,textCode;
    String code_temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        textCode= findViewById(R.id.textViewCode);

        validate_code= findViewById(R.id.validate_code);
        send_code= findViewById(R.id.send_code);
        txt_correo= findViewById(R.id.txt_correo);
        txt_code= findViewById(R.id.txt_code);

        validate_code.setOnClickListener(this);
        send_code.setOnClickListener(this);



    }
    public User findEmail(){
        User response = new User();
        for (models.User User: GlobalData.Users)
            if(User.getEmail().equals(txt_correo.getText().toString())){
                //User.setCode(code_temp);
                this.code_temp = String.valueOf( Math.round ( (Math.random() * (999999 - 100000)) + 100000 ) );

                User userAux = UserController.store(User.getUsername(), User.getName(), User.getPassword(), User.getLastname(), User.getEmail(), User.getSexo(), this.code_temp);
                GlobalData.Users.remove(User);
                GlobalData.Users.add(userAux);
                return User;
            }
        return response;
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.validate_code:
                if(txt_code.getText().toString().compareTo(this.code_temp) == 0){

                    i = new Intent(getApplicationContext(), RestablacerPassActivity.class);
                    i.putExtra("code", this.code_temp);
                    startActivity(i);
                }else
                    Toast.makeText(getApplicationContext(), "El código no corresponde al enviado", Toast.LENGTH_SHORT).show();
                    txt_code.setText("");

                break;
            case R.id.send_code:

                if(!findEmail().getName().isEmpty()){
                    textCode.setText("Código: " + this.code_temp);

                }

                else
                    Toast.makeText(getApplicationContext(), "El correo que inscribiste no se encuentra registrado", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}