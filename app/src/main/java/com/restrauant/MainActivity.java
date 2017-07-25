package com.restrauant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.restrauant.fragment.OrderListFragment;
import com.restrauant.fragment.RecordListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.icon_location);
        TextView title = (TextView) findViewById(R.id.title);
        setSupportActionBar(toolbar);
        toolbar.setTitle("哈尔滨");
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setText("收款信息"));
        tab.addTab(tab.newTab().setText("预订信息"));
        ViewPager pager = (ViewPager) findViewById(R.id.page);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.container, RecordListFragment.newInstance()).commit();

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return RecordListFragment.newInstance();
                case 1:
                    return OrderListFragment.newInstance();
                default:
                    return RecordListFragment.newInstance();
            }
        }

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "收款信息";
                case 1:
                    return "预订信息";
                default:
                    return "收款信息";
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.my) {
            Intent i = new Intent(this, MyRestrauant.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
