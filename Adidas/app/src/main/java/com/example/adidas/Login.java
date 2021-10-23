package com.example.adidas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        Account account = (Account) intent.getSerializableExtra("autoCompleteAccount");
        if(account != null){
            EditText etEmail = findViewById(R.id.etEmailLogin);
            EditText etPassword = findViewById(R.id.etPassLogin);

            etEmail.setText(account.getEmail());
            etPassword.setText(account.getPassword());
        }
    }
}
