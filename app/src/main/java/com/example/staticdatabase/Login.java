package com.example.staticdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private static String[] registeredUsernames = new String[10];
    private static String[] registeredPasswords = new String[10];
    private static int registeredUserCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login);
        Button registerBtn = findViewById(R.id.cancel);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (validateLogin(username, password)) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Username atau password salah, silahkan coba lagi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Regis.class);
                startActivity(intent);
            }
        });
    }

    public static void registerUser(String username, String password) {
        if (registeredUserCount < registeredUsernames.length) {
            registeredUsernames[registeredUserCount] = username;
            registeredPasswords[registeredUserCount] = password;
            registeredUserCount++;
        }
    }

    private boolean validateLogin(String username, String password) {
        for (int i = 0; i < registeredUserCount; i++) {
            if (registeredUsernames[i].equals(username) && registeredPasswords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}
