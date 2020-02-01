package com.zxn.nestsrcoll.frag;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zxn.nestsrcoll.R;
import com.zxn.nestsrcoll.adapter.SupportPoorAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by zxn on 2019-1-23 14:12:11.
 */
public class NewsSupportPoorFrag extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.rv_helpe_poor)
    RecyclerView rvHelpePoor;
    Unbinder unbinder;

    private String mParam1;


    public NewsSupportPoorFrag() {
    }

    public static NewsSupportPoorFrag newInstance(String param1) {
        NewsSupportPoorFrag fragment = new NewsSupportPoorFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public static NewsSupportPoorFrag newInstance() {
        NewsSupportPoorFrag fragment = new NewsSupportPoorFrag();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_support_poor, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //rvHelpePoor.setHasFixedSize(true);
        rvHelpePoor.setLayoutManager(new LinearLayoutManager(getActivity()));
        SupportPoorAdapter mAdapter = new SupportPoorAdapter();
        rvHelpePoor.setAdapter(mAdapter);

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            data.add("这是当前的条目中的第" + i);
        }
        mAdapter.setNewData(data);
    }

    public CharSequence getPageTitle() {
        return "扶贫工程";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
