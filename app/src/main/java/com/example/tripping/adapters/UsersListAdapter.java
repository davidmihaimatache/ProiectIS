package com.example.tripping.adapters;

import android.app.Activity;
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
import com.example.tripping.models.User;

import java.util.ArrayList;

public class UsersListAdapter extends ArrayAdapter<User> {

    private Context mContext;
    private int mResource;

    public UsersListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<User> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textName = convertView.findViewById(R.id.textName);
        TextView textDes = convertView.findViewById(R.id.textDes);
        TextView textAge = convertView.findViewById(R.id.textAge);


        imageView.setImageResource(R.drawable.ic_user);
        textName.setText(getItem(position).getUsername());
        textDes.setText(getItem(position).getEMailAddress());
        textAge.setText(getItem(position).getAge()+" years");

        return convertView;
    }
}
