package com.tech4use.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends ArrayAdapter<Custom> {


    //creating variable of the data sent by Chats activity
    Context context;
    ArrayList<Custom> array_lists;

    public CustomAdapter (Context context, ArrayList<Custom> array_lists) {

        super(context, R.layout.chats_arrange, array_lists);
        this.context = context;
        this.array_lists = array_lists;
    }

    //creating the lists
    public View getView(int number, View v, ViewGroup parent) {
        Custom custom_object = getItem(number);

        LayoutInflater inflater = LayoutInflater.from(getContext());

        //creating the variables of the view
        TextView new_title, new_subtitle;
        CircleImageView new_img;

        //using the findviewbyid to set the data
        v = inflater.inflate(R.layout.chats_arrange, null, false);
        new_title = (TextView)v.findViewById(R.id.display_title);
        new_subtitle = (TextView)v.findViewById(R.id.display_subtitle);
        new_img = (CircleImageView) v.findViewById(R.id.display_img);

        //setting the new data
        new_title.setText(custom_object.getTitle());
        new_subtitle.setText(custom_object.getSubtitle());
        new_img.setImageResource(custom_object.getImage());

        return v;
    }

}
