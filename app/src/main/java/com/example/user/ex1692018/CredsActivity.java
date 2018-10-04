package com.example.user.ex1692018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CredsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creds);
    }
    public void go1(View view) {
        Intent d = new Intent(this, MainActivity.class);
        startActivity(d);
    }
}
