package com.example.tripping.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tripping.R;
import com.example.tripping.models.ActiveUser;
import com.example.tripping.models.User;

import java.util.ArrayList;

public class ActiveUsersAdapter extends ArrayAdapter<ActiveUser> {

    private Context mContext;
    private int mResource;

    public ActiveUsersAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ActiveUser> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent,false);


        ImageView imageView = convertView.findViewById(R.id.imageActiveUsers);
        TextView textName = convertView.findViewById(R.id.textNameActiveUsers);
        TextView textDes = convertView.findViewById(R.id.textDesActiveUsers);
        TextView textAge = convertView.findViewById(R.id.textAgeActiveUsers);

        imageView.setImageResource(R.drawable.ic_user);
        textName.setText(getItem(position).getUsername());
        textDes.setText("Last position");
        textAge.setText(getItem(position).getLatitude()+" lat " + getItem(position).getLongitude()+" long ");

        return convertView;
    }
}
