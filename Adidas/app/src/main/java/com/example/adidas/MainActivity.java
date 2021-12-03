package com.example.adidas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int mainActivityRequest = 100;
    private Account account;
    private AccountDAO accountDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountDAO = AppDatabase.getInstance(this).getDatabase().accountDAO();

        Button btnGoogle = findViewById(R.id.btn_google);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow = new Intent(MainActivity.this, EmptyActivity.class);
                startActivity(newWindow);
            }
        });

        Button btnFb = findViewById(R.id.btn_facebook);
        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow = new Intent(MainActivity.this, EmptyActivity.class);
                startActivity(newWindow);
            }
        });

        Button btnSignUp = findViewById(R.id.btn_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow = new Intent(MainActivity.this, RegistrationActivity.class);
                //startActivity(newWindow);
                startActivityForResult(newWindow, mainActivityRequest);
            }
        });

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newWindow = new Intent(MainActivity.this, LoginActivity.class);
                newWindow.putExtra("autoCompleteAccount", account);
                startActivity(newWindow);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == mainActivityRequest) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Bundle bundle = data.getBundleExtra("bundleResponse");
                    account = (Account) bundle.getSerializable("account");
                    //Toast.makeText(MainActivity.this, account.toString(), Toast.LENGTH_LONG).show();
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            accountDAO.insert(account);
                            List<Account> accounts = accountDAO.getAccounts();
                            Log.v("accounts", accounts.toString());
                        }
                    });
                    thread.start();
                }
            }
        }
    }
}