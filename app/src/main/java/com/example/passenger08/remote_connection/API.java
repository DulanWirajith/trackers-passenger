package com.example.passenger08.remote_connection;

import com.example.passenger08.model.LoginRequest;
import com.example.passenger08.model.LoginResponse;
import com.example.passenger08.model.RegisterRequest;
import com.example.passenger08.model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    //    method for call registration route in node server
    @POST("/api/v1.0.0/registration")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    @POST("/api/v1.0.0/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
}
