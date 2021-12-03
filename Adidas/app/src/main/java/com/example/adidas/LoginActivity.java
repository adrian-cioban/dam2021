package com.example.adidas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btn_login2);
        etEmail = findViewById(R.id.etEmailLogin);
        etPassword = findViewById(R.id.etPassLogin);

        Intent intent = getIntent();
        Account account = (Account) intent.getSerializableExtra("autoCompleteAccount");
        if (account != null) {
            etEmail.setText(account.getEmail());
            etPassword.setText(account.getPassword());
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Intent newWindow = new Intent(LoginActivity.this, WorkoutsActivity.class);
                    startActivity(newWindow);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid() {
        if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(LoginActivity.this, "Email field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(LoginActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(LoginActivity.this, "Password field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
