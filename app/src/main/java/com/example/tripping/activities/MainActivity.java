package com.example.tripping.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripping.R;
import com.example.tripping.dao.DAOUser;
import com.example.tripping.interfaces.OnGetDataListener;
import com.example.tripping.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private DAOUser daoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.inputUsername);
        password = findViewById(R.id.inputPassword);
        daoUser = new DAOUser();
    }


    public void goToRegister(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void loginCheck(View view) {
        String username=((EditText)findViewById(R.id.inputUsername)).getText().toString();
        String password=((EditText)findViewById(R.id.inputPassword)).getText().toString();
        daoUser.readData(new OnGetDataListener() {
            @Override
            public void onSuccess(List<User> userList) {
                boolean isUser = false;
                for(User user:userList){
                    if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                        Intent intent = new Intent(MainActivity.this, MapActivity.class);
                        startActivity(intent);
                        isUser = true;
                    }
                }
                if(!isUser){
                    Toast.makeText(MainActivity.this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}