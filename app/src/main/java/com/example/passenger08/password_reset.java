package com.example.passenger08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class password_reset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
    }

    public void loginpage(View view) {
        TextView textView = (TextView) findViewById(R.id.back_login);
//        textView.setText("la");
//        textView.setTextColor(Color.GREEN);
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }
}
