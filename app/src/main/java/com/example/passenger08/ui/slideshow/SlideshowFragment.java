package com.example.passenger08.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.passenger08.R;

public class SlideshowFragment extends Fragment {

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
        Button submitButton = (Button)root.findViewById(R.id.submitButton);
        final TextView rating1TextView1 = (TextView) root.findViewById(R.id.textView6);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rating1TextView1.setText("rating"+ ratingBarFeedBackTime.getRating()+ "&" + ratingBarFeedBackDriver.getRating() );
                    }
                }
        );


        return root;
    }
}