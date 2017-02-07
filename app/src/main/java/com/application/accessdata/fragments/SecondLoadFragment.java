package com.application.accessdata.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;
import com.application.accessdata.adapters.ItemAdapter;
import com.application.accessdata.utilities.Item;

import java.util.ArrayList;

public class SecondLoadFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Item> mDataItems;

    public SecondLoadFragment() {
        // TODO
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_load, container, false);

        initializeData();
        recyclerView = (RecyclerView) view.findViewById(R.id.item_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        adapter = new ItemAdapter(getActivity().getApplicationContext(), mDataItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

    private void initializeData(){
        mDataItems = new ArrayList<>();
        mDataItems.add(new Item("Emma Wilson", "23 years old"));
        mDataItems.add(new Item("Lavery Maiss", "25 years old"));
        mDataItems.add(new Item("Lillie Watts", "35 years old"));
    }

}