package com.example.tripping.dao;

import androidx.annotation.NonNull;

import com.example.tripping.interfaces.OnGetDataActiveUsers;
import com.example.tripping.interfaces.OnGetDataListener;
import com.example.tripping.models.ActiveUser;
import com.example.tripping.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DAOActiveUser {

    private DatabaseReference databaseReference;

    public DAOActiveUser()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(ActiveUser.class.getSimpleName());
    }
    public Task<Void> insert(ActiveUser activeUser){
        return databaseReference.push().setValue(activeUser);
    }

    public void remove(ActiveUser activeUser){

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot usernameSnapshot:dataSnapshot.getChildren()){
                    if(activeUser.getUsername().equals(usernameSnapshot.child("username").getValue().toString())){
                        usernameSnapshot.getRef().removeValue();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void update(ActiveUser activeUser){
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot usernameSnapshot:dataSnapshot.getChildren()){
                    if(activeUser.getUsername().equals(usernameSnapshot.child("username").getValue().toString())){
                        usernameSnapshot.getRef().child("latitude").setValue(activeUser.getLatitude());
                        usernameSnapshot.getRef().child("longitude").setValue(activeUser.getLongitude());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void readData(final OnGetDataActiveUsers listener) {

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<ActiveUser> userList = new ArrayList<>();
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    String username = snapshot.child("username").getValue().toString();
                    double latitude =Double.parseDouble(snapshot.child("latitude").getValue().toString());
                    double longitude = Double.parseDouble(snapshot.child("longitude").getValue().toString());
                    ActiveUser user = new ActiveUser(username,latitude,longitude);
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
