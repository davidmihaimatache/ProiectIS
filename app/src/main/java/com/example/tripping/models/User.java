package com.example.tripping.models;

import android.location.Location;
import android.media.Image;

import com.example.tripping.enums.Status;

import java.util.Date;

public class User {


    //region Declarations

    // int userID will be added in the UserDAO
    private String mUsername;
    private String mPassword;
    private Location mLocation;
    private Image mPhoto;
    private Date mLastConnection;
    private Status mStatus;
    private String mEMailAddress;

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

    public String getUsername()
    {
        return mUsername;
    }
    public String getPassword()
    {
        return mPassword;
    }
    public Location getLocation()
    {
        return mLocation;
    }
    public Image getPhoto()
    {
        return mPhoto;
    }
    public Date getLastConnection()
    {
        return mLastConnection;
    }
    public Status getStatus()
    {
        return mStatus;
    }
    public String getEMailAddress()
    {
        return mEMailAddress;
    }

    public void setUsername(String nUsername)
    {
        mUsername = nUsername;
    }
    public void setPassword(String nUsername)
    {
        mUsername = mPassword;
    }
    public void setLocation(Location nLocation)
    {
        mLocation = nLocation;
    }
    public void setPhoto(Image nPhoto)
    {
        mPhoto = nPhoto;
    }
    public void setLastConnection(Date nLastConnection)
    {
        mLastConnection = nLastConnection;
    }
    public void setStatus(Status nStatus)
    {
        mStatus = nStatus;
    }
    public void setEMailAddress(String nEMailAddress)
    {
        mEMailAddress = nEMailAddress;
    }

    //endregion

}
