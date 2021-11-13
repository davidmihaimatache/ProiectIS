package com.example.tripping.dao;


import com.example.tripping.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.HashMap;


public class DAOUser {

    private DatabaseReference databaseReference;

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

}
