package com.restrauant.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.restrauant.R;

import java.util.ArrayList;

/**
 * Created by duanbiwei on 2017/4/19.
 */
public class RecordListFragment extends Fragment {
    private static String url="http://221.208.198.45:81/restful/rest/userinfo/test";
    ArrayList<String> data = new ArrayList<>();
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {

        }
    };
    private MyListAdapter adapter;
    private static RecordListFragment fragment;
    public static Fragment newInstance() {
        if (fragment == null) {
            fragment = new RecordListFragment();
        }
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.record_list_fragment, null, false);
        ListView list = (ListView)v.findViewById(R.id.list);
        adapter = new MyListAdapter(getActivity(), data);
        list.setAdapter(adapter);
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        final String result = Xutils.get1(url);
//                        if (result.length() > 1) {
//                            handler.post(new Runnable() {
//                                @Override
//                                public void run() {
//                                    String money = result.split("=")[1];
//                                    data.add(0, money);
//                                    adapter.notifyDataSetChanged();
//                                    Log.e("result", result);
//
//                                }
//                            });
//                        }
//                    }
//                }).start();
//            }
//        };
//        timer.schedule(task, 1000, 2000);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
    class MyListAdapter extends BaseAdapter {
        LayoutInflater inflater;
        ArrayList<String> data;
        public MyListAdapter(Context context, ArrayList<String> data) {
            this.inflater = LayoutInflater.from(context);
            this.data = data;
        }
        @Override
        public int getCount() {
            return data.size();
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
                convertView = inflater.inflate(R.layout.details_item, null);
                TextView money = (TextView) convertView.findViewById(R.id.money);
                money.setText(data.get(position) + "元");
            }
            return convertView;
        }
    }
}
