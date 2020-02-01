package com.zxn.nestsrcoll.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zxn.nestsrcoll.R;
import com.zxn.nestsrcoll.adapter.SupportPoorAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * AppBarActivity
 * SrollTabActivity
 * AppBarTabActivity
 * Created by zxn on 2019-1-23 15:03:16.
 */
public class AppBarActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, AppBarActivity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, AppBarActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);
        ButterKnife.bind(this);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        SupportPoorAdapter mAdapter = new SupportPoorAdapter();
        recyclerview.setAdapter(mAdapter);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("this the item index--->" + i);
        }
        mAdapter.setNewData(data);

    }
}
