package com.example.staticdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Regis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText usernameET = findViewById(R.id.username);
        EditText passwordET = findViewById(R.id.password);
        Button registerBtn = findViewById(R.id.login);
        Button cancelBtn = findViewById(R.id.cancel);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Regis.this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Login.registerUser(username, password);
                    Toast.makeText(Regis.this, "Daftar berhasil, silahkan login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Regis.this, Login.class);
                    startActivity(intent);
//                    finish();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Regis.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
