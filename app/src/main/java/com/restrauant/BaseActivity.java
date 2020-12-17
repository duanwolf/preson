package com.restrauant;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.widget.TextView;

/**
 * Created by duanbiwei on 2016/12/6.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public abstract void initView();
    Toolbar toolbar;
    TelephonyManager tm;
    SharedPreferences pfs;
    protected Intent intent;
    protected String userid;
    TextView textView;
    protected String mime;
    String title;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        pfs = getSharedPreferences(LoginActivity.INFO, MODE_PRIVATE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // READ_PHONE_STATE permission has not been granted.
            requestPermission();
        }
//        tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
//        mime = tm.getDeviceId();
//        userid = getSharedPreferences(LoginActivity.INFO, MODE_PRIVATE).getString("userid", "");
//        intent = getIntent();
//        initView();
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap.back);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                BaseActivity.this.finish();
//            }
//        });
//        textView = (TextView)findViewById(R.id.toolbar_title);
//        textView.setText(title);

    }
    public void setTitle(String title) {
        this.title = title;
    }
    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(BaseActivity.this,
                Manifest.permission.READ_PHONE_STATE)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // For example if the user has previously denied the permission.
            ActivityCompat.requestPermissions(BaseActivity.this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    0);
        } else {
            // READ_PHONE_STATE permission has not been granted yet. Request it directly.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE},
                    0);
        }
    }

//    public void checkMime() {
//        String result = Xutils.checkMIME(userid, tm.getDeviceId());
//        try {
//            JSONObject jsonObject = new JSONObject(result);
//            int resultCode = jsonObject.getInt("result");
//
//            if (resultCode == 1) {
//                Intent i = new Intent(BaseActivity.this, PayPasswordActivity.class);
//                startActivity(i);
//            } else {
//                if (!jsonObject.getBoolean("isMime")) {
//                    SharedPreferences.Editor editor = pfs.edit();
//                    editor.putBoolean("islogin",false);
//                    editor.putString("userlogin", "");
//                    editor.putString("loginpwd", "");
//                    editor.putString("userid", "");
//                    editor.commit();
//                    MainActivity.isLogin = false;
//                    Intent i = new Intent(BaseActivity.this, LoginActivity.class);
//                    startActivity(i);
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
    protected Dialog CreateMessageDialog(String message) {
        Dialog dialog  = new AlertDialog.Builder(this).setTitle("Restrauant").setMessage(message).setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();
        dialog.show();
        return dialog;
    }
}
