package com.example.adidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoogle = findViewById(R.id.btn_google);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent newWindow = new Intent(MainActivity.this, Registration.class);
                startActivity(newWindow);
            }
        });

        Button btnFb = findViewById(R.id.btn_facebook);
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent newWindow = new Intent(MainActivity.this, Registration.class);
                startActivity(newWindow);
            }
        });

        Button btnSignUp = findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent newWindow = new Intent(MainActivity.this, Registration.class);
                startActivity(newWindow);
            }
        });

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent newWindow = new Intent(MainActivity.this, Login.class);
                startActivity(newWindow);
            }
        });
    }
}