package com.example.tripping.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tripping.R;
import com.example.tripping.models.ActiveUser;
import com.example.tripping.models.User;

public class ProfileActivity extends AppCompatActivity {

    private User currentUserData;
    private TextView profileEmailTextView;
    private TextView profilePhoneNumberText;
    private TextView profileAgeText;
    private TextView profileUsernameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        currentUserData = (User) intent.getParcelableExtra("currentUserData");

        profileEmailTextView = (TextView)findViewById(R.id.profileEmailText);
        profileEmailTextView.setText(currentUserData.getEMailAddress());

        profilePhoneNumberText = (TextView)findViewById(R.id.profilePhoneNumber);
        profilePhoneNumberText.setText(currentUserData.getPhoneNumber());

        profileAgeText = (TextView)findViewById(R.id.profileAge);
        profileAgeText.setText(currentUserData.getAge());

        profileUsernameText = (TextView)findViewById(R.id.profileUsername);
        profileUsernameText.setText(currentUserData.getUsername());

    }
}