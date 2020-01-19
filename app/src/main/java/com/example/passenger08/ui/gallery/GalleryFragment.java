package com.example.passenger08.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.passenger08.R;
import com.example.passenger08.model.BackgroundTask;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private Button button;
    private TextView name;
    private TextView mail;
    private TextView tel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        name= root.findViewById(R.id.editName);
        name.setText(BackgroundTask.getPassengerFirstName()+" "+BackgroundTask.getPassengerSecondName());
        mail = root.findViewById(R.id.editMail);
        mail.setText(BackgroundTask.getPassengerMail());
        tel=root.findViewById(R.id.editTel);
        tel.setText(BackgroundTask.getPassengerContact());
        return root;
    }


}