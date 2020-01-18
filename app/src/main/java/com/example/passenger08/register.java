package com.example.passenger08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.passenger08.model.RegisterRequest;
import com.example.passenger08.model.RegisterResponse;
import com.example.passenger08.remote_connection.API;
import com.example.passenger08.remote_connection.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {

    private Button btnSignup;
    private EditText email;
    private EditText fistName;
    private EditText lastName;
    private EditText contact_no;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnSignup = findViewById(R.id.registerbtn);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_passenger();
            }
        });
    }

    private void register_passenger() {
        //        create API object
        API service = RetrofitClient.createService(API.class);

//        create RegisterRequest object
        RegisterRequest registerRequest = new RegisterRequest();
        email = (EditText) findViewById(R.id.editText3);
        fistName = (EditText) findViewById(R.id.editText6);
        lastName = (EditText) findViewById(R.id.editText8);
        contact_no = (EditText) findViewById(R.id.editText9);
        password = (EditText) findViewById(R.id.editText7);


        registerRequest.setPassenger_mail(email.getText().toString());
        registerRequest.setFirst_name(fistName.getText().toString());
        registerRequest.setLast_name(lastName.getText().toString());
        registerRequest.setContact_no(contact_no.getText().toString());
        registerRequest.setPassword(password.getText().toString());

//        request and get response
        final Call<RegisterResponse> isRegisterSuccessful = service.registerUser(registerRequest);

        isRegisterSuccessful.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(register.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(register.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                }

                if (response.code() == 401) {
                    Toast.makeText(register.this, response.body().getMessage(), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Context context = getApplicationContext();
                CharSequence text = "Failed to connect with the server...";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }


    private void openNewActivity() {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }

    public void register(View view) {
        TextView textView = (TextView) findViewById(R.id.logg);
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

    }
}
