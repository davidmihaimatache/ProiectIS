package com.example.tripping.models;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ActiveUser implements Parcelable {

    private double latitude;
    private double longitude;
    private String username;

    public ActiveUser(String username)
    {
        this.username = username;
        this.latitude = 0;
        this.longitude = 0;
    }

    public ActiveUser(String username,double latitude,double longitude)
    {
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected ActiveUser(Parcel in) {
        username = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<ActiveUser> CREATOR = new Creator<ActiveUser>() {
        @Override
        public ActiveUser createFromParcel(Parcel in) {
            return new ActiveUser(in);
        }

        @Override
        public ActiveUser[] newArray(int size) {
            return new ActiveUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
