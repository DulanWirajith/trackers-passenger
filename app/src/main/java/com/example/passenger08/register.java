package com.example.passenger08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class register extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = (Button) findViewById(R.id.registerbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }

    public void register(View view){
        TextView textView=(TextView)findViewById(R.id.logg);
        Intent intent= new Intent(this,register.class);
        startActivity(intent);
        
    }
}
