package com.restrauant.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.restrauant.R;

/**
 * Created by duanbiwei on 2017/4/19.
 */

public class OrderListFragment extends Fragment {
    private static OrderListFragment fragment;
    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new OrderListFragment();
        }
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.record_list_fragment, null, false);
        ListView list = (ListView)v.findViewById(R.id.list);
        list.setAdapter(new MyListAdapter(getActivity()));
        return v;
    }

    private class MyListAdapter extends BaseAdapter {
        LayoutInflater inflater;
        public MyListAdapter(Context context) {
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.orders_item, null);

            }
            return convertView;
        }
    }
}


