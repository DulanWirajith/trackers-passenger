package com.example.passenger08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.passenger08.ui.tools.ToolsFragment;

public class login extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.logbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

     public void register(View view){
        TextView textView=(TextView)findViewById(R.id.signup);
//        textView.setText("fuck");
//        textView.setTextColor(Color.GREEN);
         Intent intent= new Intent(this,register.class);
         startActivity(intent);

     }


}
