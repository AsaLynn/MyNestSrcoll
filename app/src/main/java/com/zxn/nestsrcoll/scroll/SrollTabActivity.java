package com.zxn.nestsrcoll.scroll;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.zxn.nestsrcoll.adapter.NewsPagerAdapter;
import com.zxn.nestsrcoll.widget.MyNestedScrollView;
import com.zxn.nestsrcoll.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2019-1-23 12:28:16.
 */
public class SrollTabActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.top_1)
    TextView top1;
    @BindView(R.id.dtb_cart)
    DachshundTabLayout dtbCart;
    @BindView(R.id.vp_news)
    ViewPager vpNews;
    @BindView(R.id.nsv)
    MyNestedScrollView nsv;
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, SrollTabActivity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, SrollTabActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sroll_tab);
        ButterKnife.bind(this);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);

        vpNews.setAdapter(new NewsPagerAdapter(getSupportFragmentManager()));
        dtbCart.setupWithViewPager(vpNews);

        final View rootView = findViewById(android.R.id.content);

        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);


                nsv.setMyScrollHeight(top1.getHeight());
                int height = rootView.getHeight() - dtbCart.getHeight();
                vpNews.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
            }
        });


        //dtbCart.setAnimatedIndicator(new CustomDachshundIndicator(dtbCart, SystemUtils.dp2px(getContext(), 15)));
    }
}
