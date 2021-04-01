package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPassActivity extends AppCompatActivity implements View.OnClickListener{
    Button validate_code;
    EditText txt_correo;
    String code_temp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        validate_code= findViewById(R.id.validate_code);
        txt_correo= findViewById(R.id.txt_correo);

        validate_code.setOnClickListener(this);

        code_temp = String.valueOf( Math.round ( (Math.random() * (999999 - 100000)) + 100000 ) );

        Log.d("Tag", code_temp);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.validate_code:
                i = new Intent(getApplicationContext(), RestablacerPassActivity.class);
                startActivity(i);
                break;

        }
    }
}