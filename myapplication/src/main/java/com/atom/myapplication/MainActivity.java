package com.atom.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.atom.myapplication.fragment.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    private BottomNavigationBar.OnTabSelectedListener bottomBarListener = new BottomNavigationBar.OnTabSelectedListener(){
        @Override
        public void onTabSelected(int position) {
            //from left to right, start with 0

        }
        @Override
        public void onTabUnselected(int position) {
        }
        @Override
        public void onTabReselected(int position) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_launcher, "List"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_launcher, "Blank"));
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_launcher, "Setting"));
        bottomNavigationBar.initialise();

        bottomNavigationBar.setTabSelectedListener(bottomBarListener);
    }

    private void setDefaultFragment(){
        fragments.add(new MyFragment());

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frameLayout,fragments.get(0));
        transaction.commit();
    }

}
