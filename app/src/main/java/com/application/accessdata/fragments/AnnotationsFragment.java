package com.application.accessdata.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.accessdata.R;
import com.application.accessdata.utils.ItemTypeDescriptor;

public class AnnotationsFragment extends Fragment {

    public static final String NAME_PAGE = "Annotations Page";

    public AnnotationsFragment() {
        // TODO
    }

    public static AnnotationsFragment newInstance() {
        AnnotationsFragment fragment = new AnnotationsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_annotations, container, false);
        ItemTypeDescriptor itemTypeDescriptor = new ItemTypeDescriptor(ItemTypeDescriptor.MODE_OTHER);
        Log.e("itemTypeDescriptor => ", itemTypeDescriptor.itemType + "");
        return view;
    }

}