package com.example.passenger08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.os.Build;

public class register extends AppCompatActivity {

    private Button btnSignup;
    private EditText email;
    private EditText fistName;
    private EditText lastName;
    private EditText contact_no;
    private EditText password;
//popup
//    private Context mContext;
//    private register mActivity;
//
//    private ConstraintLayout mConstraintLayout;
//    private Button mButton;
//
//    private PopupWindow mPopupWindow;


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
//popup
//        mContext = getApplicationContext();
//        mActivity = register.this;
//
//        mConstraintLayout = (ConstraintLayout) findViewById(R.id.rl);
//        mButton = (Button) findViewById(R.id.registerbtn);
//
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
//
//                // Inflate the custom layout/view
//                View customView = inflater.inflate(R.layout.varification,null);
//
//
//                mPopupWindow = new PopupWindow(
//                        customView,
//                        LayoutParams.WRAP_CONTENT,
//                        LayoutParams.WRAP_CONTENT
//                );
//
//
//                if(Build.VERSION.SDK_INT>=21){
//                    mPopupWindow.setElevation(5.0f);
//                }
//
//
//                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.ib_close);
//
//
//                closeButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Dismiss the popup window
//                        mPopupWindow.dismiss();
//                    }
//                });
//
//
//                mPopupWindow.showAtLocation(mConstraintLayout, Gravity.CENTER,0,0);
//            }
//        });
        //end

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


//    private void openNewActivity() {
//        Intent intent = new Intent(this, login.class);
//        startActivity(intent);
//
//    }

    public void register(View view) {
        TextView textView = (TextView) findViewById(R.id.logg);
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

    }
    public void login(View view) {
        TextView textView = (TextView) findViewById(R.id.logg);
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }

}
