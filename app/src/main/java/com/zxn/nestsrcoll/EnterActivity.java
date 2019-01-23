package com.zxn.nestsrcoll;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zxn.nestsrcoll.demo.MainActivity;
import com.zxn.nestsrcoll.demo.AppBarActivity;
import com.zxn.nestsrcoll.scroll.AppBarTabActivity;
import com.zxn.nestsrcoll.scroll.SrollTabActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxn on 2019-1-23 12:09:33.
 */
public class EnterActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, EnterActivity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, EnterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);
    }

    @OnClick({R.id.btn_first, R.id.btn_second, R.id.btn_three, R.id.btn_four})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_first:
                MainActivity.jumpTo(this);
                break;
            case R.id.btn_second:
                SrollTabActivity.jumpTo(this);
                break;
            case R.id.btn_three:
                AppBarActivity.jumpTo(this);
                AppBarTabActivity.jumpTo(this);
                break;
            case R.id.btn_four:
                AppBarTabActivity.jumpTo(this);
                break;
        }
    }
}
