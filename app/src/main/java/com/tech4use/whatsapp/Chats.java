package com.tech4use.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Chats extends Fragment implements AdapterView.OnItemClickListener {

    ArrayList<Custom> array_list;
    ListView l_listview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_chats, container, false);

       l_listview = (ListView)v.findViewById(R.id.chats_list);

       //adding items to the list
        array_list = new ArrayList<>();
        array_list.add(new Custom("Harsh", "Harsh: This is chat number One", R.drawable.harsh));
        array_list.add(new Custom("Google", "Google: This is chat number Two", R.drawable.google));
        array_list.add(new Custom("Linux", "Linux: This is chat number Three", R.drawable.linux));
        array_list.add(new Custom("Meme1", "Meme1: This is chat number Four", R.drawable.meme1));

        CustomAdapter adapter = new CustomAdapter(getContext(), array_list);

        l_listview.setAdapter(adapter);
        l_listview.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(getContext(), OpenChat.class);
        switch (position) {
            case 0 :
                startActivity(intent);
                break;
            case 1 :
                startActivity(intent);
                break;
            case 2 :
                startActivity(intent);
                break;
            case 3 :
                startActivity(intent);
                break;
        }

    }
}

