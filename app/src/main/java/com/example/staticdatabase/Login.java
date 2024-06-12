package com.example.staticdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText usernameET = findViewById(R.id.username);
        final EditText passwordET = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.login1);
        Button regisBtn = findViewById(R.id.regis1);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Semua input harus diisi.", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (Regis.User user : Regis.userList) {
                    if (user.username.equals(username) && user.password.equals(password)) {
                        Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        return;
                    }
                }
                Toast.makeText(Login.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
            }
        });
        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Regis.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
