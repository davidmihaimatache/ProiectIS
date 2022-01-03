package com.example.tripping.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tripping.R;
import com.example.tripping.adapters.ActiveUsersAdapter;
import com.example.tripping.adapters.UsersListAdapter;
import com.example.tripping.dao.DAOActiveUser;
import com.example.tripping.dao.DAOUser;
import com.example.tripping.interfaces.OnGetDataActiveUsers;
import com.example.tripping.interfaces.OnGetDataListener;
import com.example.tripping.models.ActiveUser;
import com.example.tripping.models.User;

import java.util.ArrayList;
import java.util.List;

public class ActiveUsersActivity extends AppCompatActivity {

    private ListView listView;
    private DAOActiveUser daoUser;
    private Context mContext;
    ArrayList<ActiveUser> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_users);

        listView = findViewById(R.id.activeUsersList);

        daoUser = new DAOActiveUser();
        usersList = new ArrayList<>();
        mContext = this;

        daoUser.readData(new OnGetDataActiveUsers() {
            @Override
            public void onSuccess(List<ActiveUser> userList) {
                for(ActiveUser user:userList){
                    if(!user.getUsername().equals("donotdeletethis")){
                        ActiveUser tempUser = new ActiveUser(user.getUsername(),user.getLatitude(),user.getLongitude());
                        usersList.add(tempUser);
                    }

                }
                ActiveUsersAdapter usersListAdapter = new ActiveUsersAdapter(mContext,R.layout.active_users_list_row,usersList);

                listView.setAdapter(usersListAdapter);

            }
        });
    }
}