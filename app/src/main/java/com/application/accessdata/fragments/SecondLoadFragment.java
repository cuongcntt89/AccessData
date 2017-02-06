package com.application.accessdata.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;
import com.application.accessdata.adapters.ItemAdapter;

public class SecondLoadFragment extends Fragment {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private String[] mDataItems;

    public SecondLoadFragment() {
        // TODO
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_load, container, false);
        mDataItems = new String[]{"Item First", "Item Second", "Item Third"};
        recyclerView = (RecyclerView) view.findViewById(R.id.item_recycler_view);
        adapter = new ItemAdapter(getActivity().getApplicationContext(), mDataItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

}
