package com.example.tripping.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripping.R;
import com.example.tripping.dao.DAOUser;
import com.example.tripping.models.User;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText edit_username = findViewById(R.id.registerUsername);
        final EditText edit_password = findViewById(R.id.registerPassword);
        Button btn = findViewById(R.id.btnRegister);
        DAOUser daoUser = new DAOUser();
        btn.setOnClickListener(view -> {
           User user = new User(edit_username.getText().toString(),edit_password.getText().toString());
            daoUser.insert(user).addOnSuccessListener(suc->{
                Toast.makeText(this, "User was inserted in database", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
    }

}