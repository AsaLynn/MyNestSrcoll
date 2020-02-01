package com.zxn.nestsrcoll.scroll;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.zxn.nestsrcoll.R;
import com.zxn.nestsrcoll.adapter.NewsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2019-1-23 15:22:18.
 */
public class AppBarTabActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.dtb_cart)
    DachshundTabLayout dtbCart;
    @BindView(R.id.vp_news)
    ViewPager vpNews;
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, AppBarTabActivity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, AppBarTabActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_tab);
        ButterKnife.bind(this);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);

        vpNews.setAdapter(new NewsPagerAdapter(getSupportFragmentManager()));
        dtbCart.setupWithViewPager(vpNews);
    }
}
