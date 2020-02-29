package com.example.passenger08.remote_connection;

import com.example.passenger08.model.GetOneReviewResponse;
import com.example.passenger08.model.GetReviewRequest;
import com.example.passenger08.model.GetReviewResponse;
import com.example.passenger08.model.LoginRequest;
import com.example.passenger08.model.LoginResponse;
import com.example.passenger08.model.PassengerReviewRequest;
import com.example.passenger08.model.RegisterRequest;
import com.example.passenger08.model.RegisterResponse;
import com.example.passenger08.model.PassengerReviewResponse;
import com.example.passenger08.model.Review;
import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    //    method for call registration route in node server
    @POST("/api/v1.0.0/registration")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    @POST("/api/v1.0.0/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("/api/v1.0.0/savereviews")
    Call<PassengerReviewResponse> passengerReview(@Body PassengerReviewRequest passengerReviewRequest);
//
    @GET("/api/v1.0.0/getreview/{passenger_mail}")
    Call<GetOneReviewResponse> getOnePassengerReview(@Path("passenger_mail") String passengerMail);

    @GET("/api/v1.0.0/getallreviews/{passenger_mail}")
    Call<GetReviewResponse> getPassengerReview(@Path("passenger_mail") String passengerMail);

    @GET("/api/v1.0.0/getallreviews/{passenger_mail}")
    Call<List<Review>> getReview(@Path("passenger_mail") String passengerMail);


//    @POST("/api/v1.0.0/getreview")
//    @HTTP(method = "POST", path = "/api/v1.0.0/getreview", hasBody = true)

//    @GET("/api/v1/basic-info/{uid}/{qid}")
//    Call<GetReviewResponse> getBasicInfo(@Path("uid") String uid,@Path("qid") String qid);
}
