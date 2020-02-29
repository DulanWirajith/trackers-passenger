package com.example.passenger08.ui.tools;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.passenger08.R;
import com.example.passenger08.model.BackgroundTask;
import com.example.passenger08.model.GetOneReviewResponse;
import com.example.passenger08.model.GetReviewRequest;
import com.example.passenger08.model.GetReviewResponse;
import com.example.passenger08.model.LoginRequest;
import com.example.passenger08.model.Review;
import com.example.passenger08.remote_connection.API;
import com.example.passenger08.remote_connection.RetrofitClient;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToolsFragment extends Fragment {

    private static final String TAG = "ToolsFragment";
    private ToolsViewModel toolsViewModel;
//    private String email;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
      
        //        create API object
        API service = RetrofitClient.createService(API.class);


        //        request and get response
//        final Call<GetReviewResponse> isgetReviewSuccessful = service.getPassengerReview(BackgroundTask.getPassengerMail());
//        final Call<List<Review>> isgetReviewSuccessful = service.getReview(BackgroundTask.getPassengerMail());
        final Call<GetReviewResponse> isgetReviewSuccessful = service.getPassengerReview(BackgroundTask.getPassengerMail());

        System.out.println("Hiiiii");
        Log.d(TAG, "onCreateView: ");

        isgetReviewSuccessful.enqueue(new Callback<GetReviewResponse>() {
            @Override
            public void onResponse(Call<GetReviewResponse> call, Response<GetReviewResponse> response) {
                GetReviewResponse all_reviews = response.body();
                ArrayList<Review> all_reviews_doe_mail=all_reviews.getReviews();
                for (Review review:all_reviews_doe_mail) {
                    System.out.println("ID is : "+review.get_id());
                    System.out.println("Reviws comment : "+review.getPassenger_comment());
                    System.out.println("Feedback time : "+review.getDriver_arrival_time());
                    System.out.println("Feedback Condition : "+review.getBus_condition());
                    System.out.println("Feedback Diesplene : "+review.getDriver_discipline());

                }

                System.out.println("hey my res is "+response);


            }

            @Override
            public void onFailure(Call<GetReviewResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

/*
        final Call<GetOneReviewResponse> isgetReviewSuccessful = service.getOnePassengerReview(BackgroundTask.getPassengerMail());
        isgetReviewSuccessful.enqueue(new Callback<GetOneReviewResponse>() {
            @Override
            public void onResponse(Call<GetOneReviewResponse> call, Response<GetOneReviewResponse> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<GetOneReviewResponse> call, Throwable t) {
                System.out.println("failed");
            }
        });
*/

        return root;
    }
}