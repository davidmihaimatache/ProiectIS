package com.example.tripping.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tripping.R;
import com.example.tripping.dao.DAOUser;
import com.example.tripping.models.User;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        final EditText edit_username = findViewById(R.id.registerUsername);
        final EditText edit_password = findViewById(R.id.registerPassword);
        final EditText edit_email = findViewById(R.id.registerEmail);
        final EditText edit_age = findViewById(R.id.registerAge);
        final EditText edit_phoneNumber = findViewById(R.id.registerPhoneNumber);


        Button btn = findViewById(R.id.btnRegister);
        DAOUser daoUser = new DAOUser();
        btn.setOnClickListener(view -> {

            if(validateFields(edit_username,edit_password,edit_email,edit_phoneNumber,edit_age)){
                User user = new User();
                user.setUsername(edit_username.getText().toString());
                user.setPassword(edit_password.getText().toString());
                user.setPhoneNumber(edit_phoneNumber.getText().toString());
                user.setAge(edit_age.getText().toString());
                user.setEMailAddress(edit_email.getText().toString());

                daoUser.insert(user).addOnSuccessListener(suc->{
                    Toast.makeText(this, "User was inserted in database", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er->{
                    Toast.makeText(this, er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }

        });
    }


    public boolean validateFields(EditText edit_username,EditText edit_password,EditText edit_email,EditText edit_phoneNumber,EditText edit_age) {
        boolean valid = true;

        if(!validateUsername(edit_username)){
            valid=false;
        }

        if(!validatePassword(edit_password)){
            valid=false;
        }

        if(!validateAge(edit_age)){
            valid=false;
        }

        if(!validateEmail(edit_email)){
            valid=false;
        }

        if(!validatePhoneNumber(edit_phoneNumber)){
            valid=false;
        }

        return valid;
    }

    public boolean validateUsername(EditText edit_username){
        if(edit_username.getText().toString().isEmpty()){
            edit_username.setError("Required field");
            return false;
        }

        edit_username.setError(null);

        return true;
    }

    public boolean validatePassword(EditText edit_password){
        String passwordText = edit_password.getText().toString();

        if(passwordText.isEmpty()){
            edit_password.setError("Required field");
            return false;
        }
        if(passwordText.length()<8){
            edit_password.setError("Password must contain at least 8 characters");
            return false;
        }

        edit_password.setError(null);
        return true;
    }

    public boolean validateEmail(EditText edit_email){
        Pattern p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher m = p.matcher(edit_email.getText().toString());
        boolean valid = m.matches();

        if(edit_email.getText().toString().isEmpty()){
            edit_email.setError("Required field");
            return false;
        }
        if(!valid){
            edit_email.setError("Email address is not valid");
            return false;
        }

        edit_email.setError(null);
        return true;
    }

    public boolean validatePhoneNumber(EditText edit_phoneNumber){
        String passwordText = edit_phoneNumber.getText().toString();

        if(passwordText.isEmpty()){
            edit_phoneNumber.setError("Required field");
            return false;
        }
        if(passwordText.length()!=10){
            edit_phoneNumber.setError("Phone number must be 10 characters long");
            return false;
        }

        edit_phoneNumber.setError(null);
        return true;
    }

    public boolean validateAge(EditText edit_age){
        String ageText = edit_age.getText().toString();

        Pattern p = Pattern.compile("^[1-9]?\\d$");
        Matcher m = p.matcher(edit_age.getText().toString());
        boolean valid = m.matches();

        if(ageText.isEmpty()){
            edit_age.setError("Required field");
            return false;
        }

        if(!valid){
            edit_age.setError("Enter a valid age");
            return false;
        }
        edit_age.setError(null);

        return true;
    }
}