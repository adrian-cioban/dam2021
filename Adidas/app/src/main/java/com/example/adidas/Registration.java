package com.example.adidas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    private EditText etFirstName, etLastName, etEmail, etPassword, etLocation, etBirthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Toolbar toolbar = (Toolbar) findViewById(R.id.signUpToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("REGISTRATION");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button btnJoin = findViewById(R.id.btnJoin);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPass);
        etLocation = findViewById(R.id.etLocation);
        etBirthdate = findViewById(R.id.etBirthdate);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    Account account = new Account();
                    account.setFirstName(etFirstName.getText().toString());
                    account.setLastName(etLastName.getText().toString());
                    account.setEmail(etEmail.getText().toString());
                    account.setPassword(etPassword.getText().toString());
                    account.setLocation(etLocation.getText().toString());
                    account.setBirthdate(etBirthdate.getText().toString());

                    //Toast.makeText(Registration.this, account.toString(), Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("account", account);
                    Intent intent = new Intent();
                    intent.putExtra("bundleResponse", bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValid() {
        if (etFirstName.getText().toString().isEmpty()) {
            Toast.makeText(Registration.this, "First name field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etLastName.getText().toString().isEmpty()) {
            Toast.makeText(Registration.this, "Last name field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etEmail.getText().toString().isEmpty()) {
            Toast.makeText(Registration.this, "Email field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(isEmailValid(etEmail.getText().toString()))) {
            Toast.makeText(Registration.this, "Invalid email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etPassword.getText().toString().isEmpty()) {
            Toast.makeText(Registration.this, "Password field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etLocation.getText().toString().isEmpty()) {
            Toast.makeText(Registration.this, "Location field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (etBirthdate.getText().toString().isEmpty()) {
            Toast.makeText(Registration.this, "Birthdate field is empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}