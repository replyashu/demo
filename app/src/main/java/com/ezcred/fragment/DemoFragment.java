package com.ezcred.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezcred.R;
import com.ezcred.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 25/04/17.
 */

public class DemoFragment extends Fragment {

    private View view;
    private RecyclerView recyclerDemo;
    private FragmentAdapter adapter;
    private ArrayList<String> time;
    private ArrayList<String> content;

    public DemoFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        time = getArguments().getStringArrayList("time");
        content = getArguments().getStringArrayList("val");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dummy, container, false);
        recyclerDemo = (RecyclerView) view.findViewById(R.id.recyclerCred);
        recyclerDemo.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new FragmentAdapter(time, content);

        recyclerDemo.setAdapter(adapter);

        return view;
    }
}
