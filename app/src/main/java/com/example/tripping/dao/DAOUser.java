package com.example.tripping.dao;


import androidx.annotation.NonNull;

import com.example.tripping.interfaces.OnGetDataListener;
import com.example.tripping.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;


public class DAOUser {

    private DatabaseReference databaseReference;
    private List<User> usersList;
    public DAOUser()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        //this get reference for the node("table") from db with the name of User
        databaseReference = db.getReference(User.class.getSimpleName());
    }

    // insert a new user in database
    public Task<Void> insert(User user){
        return databaseReference.push().setValue(user);
    }

    // update user in database
    public Task<Void> update(String key, HashMap<String,Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }

    // remove user from database
    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }

    public void readData(final OnGetDataListener listener) {

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<User>userList = new ArrayList<>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    User user = new User();
                    user.setUsername(snapshot.child("username").getValue().toString());
                    user.setPassword(snapshot.child("password").getValue().toString());
                    user.setAge(snapshot.child("age").getValue().toString());
                    user.setEMailAddress(snapshot.child("emailAddress").getValue().toString());
                    user.setPhoneNumber(snapshot.child("phoneNumber").getValue().toString());

                    userList.add(user);
                }
                listener.onSuccess(userList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
