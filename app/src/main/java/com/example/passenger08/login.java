package com.example.passenger08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.passenger08.model.LoginRequest;
import com.example.passenger08.model.LoginResponse;
import com.example.passenger08.remote_connection.API;
import com.example.passenger08.remote_connection.RetrofitClient;
import com.google.gson.Gson;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
    Button button;
    private EditText email;
    private EditText password;

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
        Toast.makeText(login.this, "login clicked!!!", Toast.LENGTH_LONG).show();

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
        loginUser();


    }

    private void loginUser() {
        //        create API object
        API service = RetrofitClient.createService(API.class);

        //        create LoginRequest object
        LoginRequest loginRequest = new LoginRequest();
        email = (EditText) findViewById(R.id.loginMail);
        password = (EditText) findViewById(R.id.loginPassword);

        loginRequest.setPassenger_mail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        //        request and get response
        final Call<LoginResponse> isLogginSuccessful = service.loginUser(loginRequest);
        isLogginSuccessful.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body().isUserRight()) {
                        Toast.makeText(login.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        String message=jObjError.getString("message");
                        Toast.makeText(login.this, message, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(login.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Context context = getApplicationContext();
                CharSequence text = "Failed to connect with the server...";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });


    }

    public void register(View view) {
        TextView textView = (TextView) findViewById(R.id.signup);
//        textView.setText("fuck");
//        textView.setTextColor(Color.GREEN);
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

    }


}
