package com.example.staticdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Regis extends AppCompatActivity {

    static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText usernameET = findViewById(R.id.username);
        final EditText passwordET = findViewById(R.id.password);
        Button registerBtn = findViewById(R.id.regis2);
        Button loginBtn = findViewById(R.id.login2);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Regis.this, "Semua input harus diisi.", Toast.LENGTH_SHORT).show();
                } else {
                    userList.add(new User(username, password));
                    Toast.makeText(Regis.this, "Daftar berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Regis.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Regis.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    class User {
        String username;
        String password;

        User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
