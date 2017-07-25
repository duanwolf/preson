package com.restrauant;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.restrauant.model.CardAndPerson;

import java.util.ArrayList;

/**
 * Created by duanbiwei on 2016/12/7.
 */
public class CardListActivity extends BaseActivity {
    private static ArrayList<CardAndPerson> lists = null;
    private ListView list;
    @Override
    public void initView() {
        setContentView(R.layout.choose_person);
        setTitle("选择收款人/绑定卡号");
        lists = new ArrayList<>();
        String name = getIntent().getStringExtra("name");
        final String num = getIntent().getStringExtra("num");
        final int kind = getIntent().getIntExtra("kind", 0);
        CardAndPerson item = new CardAndPerson(name, num);
        lists.add(item);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(new ListAdapter(this, lists));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CardAndPerson item = lists.get(position);
                Intent i = new Intent(CardListActivity.this, ReturnMoneyActivity.class);
                if (0 == kind) {
                    i.putExtra("title", "转账");
                } else {
                    i.putExtra("title", "信用卡还款");
                }
                i.putExtra("name", item.getName());
                i.putExtra("cardnum", item.getCardNum());
                i.putExtra("cardtype","ICBC");
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.add_list,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add) {
//            Intent i = new Intent(CardListActivity.this, BindCardActivity.class);
//            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class ListAdapter extends ArrayAdapter<CardAndPerson> {
        ArrayList<CardAndPerson> list;
        public ListAdapter(Context context, ArrayList<CardAndPerson> objects) {
            super(context, 0, objects);
            this.list = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent ) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.choose_person_item, parent, false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView num = (TextView) convertView.findViewById(R.id.card_num);
            name.setText(list.get(position).getName());
            num.setText(list.get(position).getCardNum());
            return convertView;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
