package com.restrauant;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.restrauant.model.AListOfGood;
import com.restrauant.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class MyMenuActivity extends AppCompatActivity {
    private String[] strings = {"热销榜", "热门商品", "最新商品", "家常溜炒", "风味凉菜", "精品小炒"};
    private List<AListOfGood> product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMenuActivity.this.finish();
            }
        });
        final ListView goodsList = (ListView) findViewById(R.id.goods);
        final ListView allKind = (ListView) findViewById(R.id.all_kind);
        product = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            AListOfGood a = new AListOfGood();
            a.setType(strings[i]);
            a.setIndex(i);
            List<FoodItem> foods = new ArrayList<>();
            foods.add(new FoodItem());
            foods.add(new FoodItem());
            a.setProduct(foods);
            product.add(a);
        }
        MyGoodAdapter goodAdapter = new MyGoodAdapter(strings);
        goodsList.setAdapter(goodAdapter);
        MyKindsAdapter kAdapter = new MyKindsAdapter();
        allKind.setAdapter(kAdapter);
        allKind.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                View view1 = goodsList.getChildAt(lfGetProductSection(firstVisibleItem));
                for (int i = 0; i < goodsList.getChildCount(); i++) {
                    if (i == lfGetProductSection(firstVisibleItem)) {
                        view1.setBackgroundColor(Color.WHITE);
                        TextView t = (TextView) view1.findViewById(R.id.good);
                        t.setTextColor(getResources().getColor(R.color.blue));
                    } else {
                        goodsList.getChildAt(i).setBackgroundColor(Color.rgb(247, 247, 247));
                        TextView t = (TextView) goodsList.getChildAt(i).findViewById(R.id.good);
                        t.setTextColor(Color.BLACK);
                    }
                }

            }
        });

        goodsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < goodsList.getChildCount(); i++) {
                    if (i == position) {
                        view.setBackgroundColor(Color.WHITE);
                        TextView t = (TextView) view.findViewById(R.id.good);
                        t.setTextColor(getResources().getColor(R.color.blue));
                    } else {
                        goodsList.getChildAt(i).setBackgroundColor(Color.rgb(247, 247, 247));
                        TextView t = (TextView) goodsList.getChildAt(i).findViewById(R.id.good);
                        t.setTextColor(Color.BLACK);
                    }
                    allKind.setSelection(getProductSection(position));
                }
            }
        });
    }

    private int getProductSection(int pos) {
        int count = 0;
        for (int i = 0; i < pos; i++) {
            count += product.get(i).getProduct().size();
        }
        return count;
    }
    private int lfGetProductSection(int firstview) {
        int count = 0;
        for (int i = 0; i < product.size(); i++) {
            int size = product.get(i).getProduct().size();
            if (firstview > size) {
                firstview -= size;
                count += 1;
            }
        }
        return count;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            Intent i = new Intent(MyMenuActivity.this, AllKindsMenuActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private class MyGoodAdapter extends BaseAdapter {
        private String[] strings;
        private MyGoodAdapter(String[] strings) {
            this.strings = strings;
        }

        @Override
        public int getCount() {
            return strings.length;
        }

        @Override
        public Object getItem(int position) {
            return strings[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.goods_item, null);
                TextView t = (TextView) convertView.findViewById(R.id.good);
                t.setText(strings[position]);

            }
            return convertView;
        }


    }

    private class MyKindsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            int count = 0;
            for (int i = 0; i < product.size(); i++) {
                count += product.get(i).getProduct().size();
            }
            return count;
        }

        @Override
        public int getItemViewType(int position) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            int count = 0;
            for (int i = 0; i < product.size(); i++) {
                count += product.get(i).getProduct().size() + 1;
                list.add(count);
            }
            return list.contains(position) ? 0 : 1;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.kind_item, null);
            }
            return convertView;
        }

        private String getText(int pos) {
            int j = 0;
            for (int i = 0; i < product.size(); i++) {
                int count = product.get(i).getProduct().size() + 1;
                if (pos < count) {
                    j = i;
                    break;
                } else {
                    pos -= count;
                }
            }
            return strings[j];
        }
    }
}
