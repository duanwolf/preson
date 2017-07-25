package com.restrauant;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by duanbiwei on 2016/10/13.
 */
public class ReturnMoneyActivity extends Activity {
    private String url = "http://221.208.198.45:900/ChatOnline/bank/withdrawscash";
//    PayPopupWindow p;
    private String userid;
//    private Handler handler = new Handler(getMainLooper()) {
//        public void handleMessage(Message msg) {
//            try {
//                JSONObject jsobj = new JSONObject(msg.obj.toString());
//                String message = "";
//                if (jsobj.getInt("result") == 0) {
//                    message = "成功";
//                } else {
//                    message = jsobj.getString("errmessage");
//                }
//                p.closePop();
//                AlertDialog.Builder builder = new AlertDialog.Builder(ReturnMoneyActivity.this);
//                builder.setMessage(message).setTitle("提现").setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                }).show();
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//    };
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
//        userid = getSharedPreferences(LoginActivity.INFO, MODE_PRIVATE).getString("userid", "");
//
        setContentView(R.layout.return_money);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
//        Button btn = (Button) findViewById(R.id.next_step);
//        TextView title = (TextView) toolbar.findViewById(R.id.toolbar_title);
//        title.setText(getIntent().getStringExtra("title"));
//        TextView name = (TextView) findViewById(R.id.name);
//        TextView card = (TextView) findViewById(R.id.card_num);
//        name.setText(getIntent().getStringExtra("name"));
//        card.setText(getIntent().getStringExtra("cardnum"));
//        EditText money = (EditText) findViewById(R.id.money);
//        final SharedPreferences pfs = getSharedPreferences(LoginActivity.INFO, MODE_PRIVATE);
//        CardInfo cardInfo = (CardInfo) getIntent().getSerializableExtra("card");
//        final Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userid", pfs.getString("userid", ""));
//        map.put("accounts", cardInfo.getNum());
//        map.put("bankusername", cardInfo.getUserName());
//        map.put("bankcard", cardInfo.getNum());
//        map.put("banktype", "2");
//        map.put("accounts", Float.valueOf(money.getText().toString()));
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                p = new PayPopupWindow(ReturnMoneyActivity.this, v);
//                p.setInputFinish(new PasswordView.OnPasswordInputFinish() {
//                    @Override
//                    public void inputFinish() {
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (Xutils.checkPayPwd(userid, p.getPassword())) {
//                                    String result = Xutils.POST(url, map);
//                                    Message msg = new Message();
//                                    msg.obj = result;
//                                    handler.sendMessage(msg);
//                                } else {
//                                    handler.post(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            Toast.makeText(ReturnMoneyActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
//                                            p.closePop();
//                                        }
//                                    });
//                                }
//                            }
//                        }).start();
//                    }
//                });
//                p.show();
//            }
//        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReturnMoneyActivity.this.finish();
            }
        });

    }
}
