package com.example.tripping.interfaces;

import com.example.tripping.models.ActiveUser;
import com.example.tripping.models.User;

import java.util.List;

public interface OnGetDataListener {
    void onSuccess(List<User> userList);
}
