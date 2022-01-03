package com.example.tripping.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tripping.R;
import com.example.tripping.adapters.UsersListAdapter;
import com.example.tripping.dao.DAOUser;
import com.example.tripping.interfaces.OnGetDataListener;
import com.example.tripping.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private ListView listView;
    private DAOUser daoUser;
    private Context mContext;
    ArrayList<User> usersList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        listView = findViewById(R.id.usersList);

        daoUser = new DAOUser();
        usersList = new ArrayList<>();
        mContext = this;

        daoUser.readData(new OnGetDataListener() {
            @Override
            public void onSuccess(List<User> userList) {
                for(User user:userList){
                    User tempUser = new User();
                    tempUser.setUsername(user.getUsername());
                    tempUser.setEMailAddress(user.getEMailAddress());
                    tempUser.setAge(user.getAge());

                    usersList.add(tempUser);
                }
                UsersListAdapter usersListAdapter = new UsersListAdapter(mContext,R.layout.mylist,usersList);

                listView.setAdapter(usersListAdapter);

            }
        });



    }
}