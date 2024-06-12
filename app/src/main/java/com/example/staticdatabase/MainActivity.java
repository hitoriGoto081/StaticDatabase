package com.example.staticdatabase;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Regis.userList.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, Regis.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(MainActivity.this, FinalScore.class);
            startActivity(intent);
            finish();
        }
    }
}
