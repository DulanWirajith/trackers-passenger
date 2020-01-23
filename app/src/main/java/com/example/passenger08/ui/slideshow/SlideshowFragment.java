package com.example.passenger08.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.passenger08.R;
import com.example.passenger08.model.BackgroundTask;
import com.example.passenger08.model.PassengerReviewRequest;
import com.example.passenger08.model.PassengerReviewResponse;
import com.example.passenger08.remote_connection.API;
import com.example.passenger08.remote_connection.RetrofitClient;

import org.json.JSONObject;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowFragment extends Fragment {

    private String email;
    private float discipline;
    private float arrival_time;
    private float  bus_condition;
    private Date reviewed_date;
    private String bus_number;
    private EditText passenger_comment;
    String curruntDate;

//    private EditText comment;



    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final RatingBar ratingBarFeedBackTime = (RatingBar) root.findViewById(R.id.feedBackRatingBarTime);
        final RatingBar ratingBarFeedBackDriver = (RatingBar) root.findViewById(R.id.feedBackRatingBarDriver);
        final RatingBar ratingBarFeedBackCondition = (RatingBar) root.findViewById(R.id.feedBackRatingBarCondition);

        passenger_comment = (EditText)root.findViewById(R.id.passengerComment);

        Calendar calendar = Calendar.getInstance();
        curruntDate= DateFormat.getDateInstance().format(calendar.getTime());

//        dropdown Select Bus
        String [] values =
                {"NB-2010","NL-1234","NB-5865"};
        Spinner spinner = (Spinner) root.findViewById(R.id.busNoDropDwn);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        bus_number=spinner.getSelectedItem().toString();



        Button submitButton = (Button)root.findViewById(R.id.submitButton);
//        final TextView rating1TextView1 = (TextView) root.findViewById(R.id.textView6);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        discipline= ratingBarFeedBackDriver.getRating();
                        arrival_time = ratingBarFeedBackTime.getRating();
                        bus_condition= ratingBarFeedBackCondition.getRating();
//                        rating1TextView1.setText("rating"+ ratingBarFeedBackTime.getRating()+ "&" + ratingBarFeedBackDriver.getRating()+" &"+ ratingBarFeedBackCondition.getRating() );
                        sendTODatabase();
                    }
                }
        );
        return root;
    }

    private void sendTODatabase() {
//        create API object
        API service = RetrofitClient.createService(API.class);

//        createSlideshowFragmentRequest
        PassengerReviewRequest passengerReviewRequest = new PassengerReviewRequest();

        email= BackgroundTask.getPassengerMail();
        passengerReviewRequest.setPassenger_mail(email.toString());
        passengerReviewRequest.setDriver_arrival_time(arrival_time);
        passengerReviewRequest.setBus_condition(bus_condition);
        passengerReviewRequest.setDriver_discipline(discipline);
        passengerReviewRequest.setBus_number(bus_number);
        System.out.println(passenger_comment.toString());
        passengerReviewRequest.setPassenger_comment(passenger_comment.getText().toString());

//        date conversion
        String dateString = curruntDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(convertedDate);
        passengerReviewRequest.setReviewed_date(convertedDate);

        //        request and get response
        final Call<PassengerReviewResponse> isReviewSuccessful = service.passengerReview(passengerReviewRequest);

        isReviewSuccessful.enqueue(new Callback<PassengerReviewResponse>() {
            @Override
            public void onResponse(Call<PassengerReviewResponse> call, Response<PassengerReviewResponse> response) {
//                System.out.println(response.body().getMessage());

                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();

                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        String message = jObjError.getString("message");
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<PassengerReviewResponse> call, Throwable t) {


            }
        });



    }
}
