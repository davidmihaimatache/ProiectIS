package com.example.tripping.interfaces;

import com.example.tripping.models.ActiveUser;

import java.util.List;

public interface OnGetDataActiveUsers {
    void onSuccess(List<ActiveUser> userList);
}
