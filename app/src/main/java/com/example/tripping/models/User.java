package com.example.tripping.models;

import android.location.Location;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.tripping.enums.Status;

import java.util.Date;

public class User implements Parcelable {


    //region Declarations

    // int userID will be added in the UserDAO
    private String mUsername;
    private String mPassword;
    private String mEMailAddress;
    private String mAge;
    private String mPhoneNumber;

    //endregion

    //region Constructors

    public User()
    {

    }

    public User(String mUsername, String mPassword) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }
//endregion

    //region Getters and Setters

    protected User(Parcel in) {
        mUsername = in.readString();
        mPassword = in.readString();
        mEMailAddress = in.readString();
        mAge = in.readString();
        mPhoneNumber = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername()
    {
        return mUsername;
    }
    public String getPassword()
    {
        return mPassword;
    }

    public String getEMailAddress() {
        return mEMailAddress;
    }

    public void setEMailAddress(String mEMailAddress) {
        this.mEMailAddress = mEMailAddress;
    }

    public String getAge() {
        return mAge;
    }

    public void setAge(String mAge) {
        this.mAge = mAge;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public void setUsername(String username){
        this.mUsername = username;
    }

    public void setPassword(String password){
        this.mPassword = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUsername);
        parcel.writeString(mPassword);
        parcel.writeString(mEMailAddress);
        parcel.writeString(mAge);
        parcel.writeString(mPhoneNumber);
    }

    //endregion

}
