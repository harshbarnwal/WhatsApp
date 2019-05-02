package com.tech4use.whatsapp;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ViewPager v_viewpager;
    TabLayout t_tablayout;
    Fragment fragment = null;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //removing actionbar and adding toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

        v_viewpager = (ViewPager)findViewById(R.id.viewpager);
        t_tablayout = (TabLayout) findViewById(R.id.tab_layout);

        fragment = new Chats();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewpager, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        t_tablayout.addTab(t_tablayout.newTab().setIcon(R.drawable.camera));
        t_tablayout.addTab(t_tablayout.newTab().setText("Chats"));
        t_tablayout.addTab(t_tablayout.newTab().setText("Status"));
        t_tablayout.addTab(t_tablayout.newTab().setText("Calls"));

        final MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), t_tablayout.getTabCount());
        v_viewpager.setAdapter(adapter);

        v_viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(t_tablayout));

        t_tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                v_viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //creating the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //creating and inflating menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //adding click events on menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle()+" selected", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
