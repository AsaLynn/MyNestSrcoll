package com.zxn.nestsrcoll.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.zxn.nestsrcoll.widget.MyNestedScrollView;
import com.zxn.nestsrcoll.R;

/**
 * recyclerView 要固定大小 不然的话 会绘制出所有的item
 * recyclerView的高度为 root的高度 减去头部textview的高度
 * 创建日期：2018/3/26 on 10:31
 * 描述:
 * 作者:Li
 */

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

    RecyclerView rv;
    MyNestedScrollView nsv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        nsv = findViewById(R.id.nsv);


        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new SimpleTestAdapter());


        final View rootView = findViewById(android.R.id.content);

        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                View topView1 = findViewById(R.id.top_1);
                View topView2 = findViewById(R.id.top_2);

                nsv.setMyScrollHeight(topView1.getHeight());
                int rvNewHeight = rootView.getHeight() - topView2.getHeight();

                rv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, rvNewHeight));

            }
        });

//        Log.d(TAG,"rootView height " + rootView.getHeight());

//        View topView = findViewById(R.id.top_1);
//        Log.d(TAG,"topView height " + topView.getHeight() + " top " + topView.getTop());
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

}
