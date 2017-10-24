package com.atom.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.atom.myapplication.dummy.DummyContent;
import com.atom.myapplication.fragment.BlankFragment;
import com.atom.myapplication.fragment.ItemFragment;
import com.atom.myapplication.fragment.MyFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    private BottomNavigationBar.OnTabSelectedListener bottomBarListener = new BottomNavigationBar.OnTabSelectedListener(){
        @Override
        public void onTabSelected(int position) {
            Log.i("", position + "=============================================");
            //from left to right, start with 0
            if(fragments != null && position < fragments.size()){
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.frameLayout,fragments.get(position));
                transaction.commitAllowingStateLoss();
            }
        }
        @Override
        public void onTabUnselected(int position) {
            if (fragments != null) {
                if (position < fragments.size()) {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    Fragment fragment = fragments.get(position);
                    ft.remove(fragment);
                    ft.commitAllowingStateLoss();
                }
            }
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
        setDefaultFragment();
    }

    private void setDefaultFragment(){
        fragments.add(ItemFragment.newInstance(1));
        fragments.add(new MyFragment());
        fragments.add(new BlankFragment("", "BFragment 2"));

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frameLayout,fragments.get(2));
        transaction.commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.i("",item.content);
    }
}
