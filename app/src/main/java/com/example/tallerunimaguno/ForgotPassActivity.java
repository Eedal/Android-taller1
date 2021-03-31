package com.example.tallerunimaguno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPassActivity extends AppCompatActivity implements View.OnClickListener{
    Button validate_code;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        validate_code= findViewById(R.id.validate_code);

        validate_code.setOnClickListener(this);

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