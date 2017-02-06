package com.application.accessdata.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.accessdata.R;

/**
 * Created by CuongNV on 2/6/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context mContext;
    private String[] mDataset;

    public ItemAdapter(Context context, String[] dataset) {
        this.mContext = context;
        this.mDataset = dataset;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_adapter, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    /* View holder */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;

        public ViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.info_text);
        }
    }

}