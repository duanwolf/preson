package com.restrauant;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.restrauant.model.Transaction;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by duanbiwei on 2016/12/9.
 */
public class TransactionsActivity extends BaseActivity {
    ArrayList<Transaction> list = null;
    private String url = "http://221.208.198.45:900/ChatOnline/rest/order/getbill";


    @Override
    public void initView() {
        setContentView(R.layout.transactions);
        setTitle("账单");
        list = new ArrayList<>();
        setData();


    }

    private void setData() {
        Random random = new Random();
//        SharedPreferences pfs = getSharedPreferences(LoginActivity.INFO, MODE_PRIVATE);
//        final String cardphone = pfs.getString("userlogin","");
//        final String userid = pfs.getString("userid", "");
//        final Map<String, Object> map = new HashMap<>();
//        map.put("user_id",userid);
//        Log.i("info",userid);
//        final Handler loginHandler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                String result = msg.getData().getString("result");
//                Log.i("info",result);
//                try {
//                    JSONObject jo = new JSONObject(result);
//                    if(jo.getString("resultcode").equals("0")){
//                        JSONArray ja =jo.getJSONArray("data");
//                        for (int i = 0; i < ja.length(); i++) {
//                            Log.i("info","-----------------------------");
//                            JSONObject jo2 = ja.getJSONObject(i);
//                            String name = getName(jo2.getInt("opttype"));
//                            String detail = (jo2.getInt("status")==2)?(getDetail(jo2.getInt("status"))+":"+jo2.getString("messages")):getDetail(jo2.getInt("status"));
//                            String price = (jo2.getInt("opttype")==7)?jo2.getString("accounts"):"-"+jo2.getString("accounts");
//                            Transaction transaction = new Transaction(name, detail, price,new Date(jo2.getLong("creattime")));
//                            list.add(transaction);
//                        }
//                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
//                        RecyclerList adapter = new RecyclerList(list);
//                        LinearLayoutManager manager = new LinearLayoutManager(TransactionsActivity.this);
//                        manager.setOrientation(LinearLayoutManager.VERTICAL);
//                        recyclerView.setLayoutManager(manager);
//                        MyItemDecoration itemDecoration = new MyItemDecoration(TransactionsActivity.this);
//                        recyclerView.addItemDecoration(itemDecoration);
//                        recyclerView.setAdapter(adapter);
//                    }else{
//                        Toast.makeText(TransactionsActivity.this,"查询账单失败，请重试！", Toast.LENGTH_LONG).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String result = Xutils.POST(url, map);
//                Message message = new Message();
//                Bundle bundle = new Bundle();
//                bundle.putString("result", result);
//                message.setData(bundle);
//                loginHandler.sendMessage(message);
//            }
//        }).start();

    }

    private String getName(int opt){
        String name = "";
        switch (opt){
            case 0:
                name = "转账";
                break;
            case 1:
                name = "还款";
                break;
            case 2:
                name = "提现";
                break;
            case 3:
                name = "手机费";
                break;
            case 4:
                name = "手机流量";
                break;
            case 5:
                name = "加油卡";
                break;
            case 6:
                name = "宽带缴费";
                break;
            case 7:
                name = "充值";
                break;
            default:
                name = "其他";
                break;
        }
        return name;
    }

    private String getDetail(int status){
        String detail = "";
        switch (status){
            case 0:
                detail = "未完成";
                break;
            case 1:
                detail = "完成";
                break;
            case 2:
                detail = "支付失败并退款";
                break;
            default:
                detail = "其他";
                break;
        }
        return detail;
    }
    class RecyclerList extends RecyclerView.Adapter<RecyclerList.TransactionItem> {
        private ArrayList<Transaction> lists = null;

        public RecyclerList(ArrayList<Transaction> lists) {
            this.lists = lists;
        }
        @Override
        public TransactionItem onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_item, parent, false);
            TransactionItem item = new TransactionItem(v);
            return item;
        }


        @Override
        public void onBindViewHolder(TransactionItem holder, int position) {
            holder.name.setText(lists.get(position).getName());
            holder.detail.setText(lists.get(position).getDetails());
            holder.date.setText(lists.get(position).getTime());
            holder.price.setText(lists.get(position).getPrice());
        }


        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }


        @Override
        public int getItemCount() {
            return lists.size();
        }

        class TransactionItem extends RecyclerView.ViewHolder {
            TextView name, detail, date, price;
            public TransactionItem(View v) {
                super(v);
                name = (TextView) v.findViewById(R.id.name);
                detail = (TextView) v.findViewById(R.id.details);
                date = (TextView) v.findViewById(R.id.time);
                price = (TextView) v.findViewById(R.id.price);
            }
        }

    }

    class MyItemDecoration extends RecyclerView.ItemDecoration {
        private final int[] ATTRS = new int[]{
                android.R.attr.listDivider
        };

        private Drawable mDivider;
        public MyItemDecoration(Context context) {
            TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDivider = a.getDrawable(0);
            a.recycle();
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);

                //获得child的布局信息
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }
    }
}
