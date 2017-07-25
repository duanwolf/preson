package com.restrauant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MyRestrauant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_restrauant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyRestrauant.this.finish();
            }
        });
        TextView myMenu = (TextView) findViewById(R.id.my_menu);
        myMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyRestrauant.this, MyMenuActivity.class);
                startActivity(i);
            }
        });
        TextView balance = (TextView) findViewById(R.id.balance);
        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyRestrauant.this, BalanceActivity.class);
                startActivity(i);
            }
        });

        TextView rating = (TextView) findViewById(R.id.rating);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyRestrauant.this, RatingActivity.class);
                startActivity(i);
            }
        });

        TextView details = (TextView) findViewById(R.id.details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyRestrauant.this, DetailsActivity.class);
                startActivity(i);
            }
        });

        TextView getMoney = (TextView) findViewById(R.id.get_money);
        getMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyRestrauant.this, GetMoneyActivity.class);
                startActivity(i);
            }
        });

        TextView bank = (TextView) findViewById(R.id.bank);
        bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyRestrauant.this, BankActivity.class);
                startActivity(i);
            }
        });

        TextView myInfo = (TextView) findViewById(R.id.orders);
        myInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MyRestrauant.this, MoreInfoActivity.class);
//                startActivity(i);
            }
        });
    }
}
