package com.application.accessdata.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.accessdata.R;
import com.application.accessdata.entity.Item;

import java.util.ArrayList;

/**
 * Created by CuongNV on 2/6/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Item> mDataset;

    public ItemAdapter(Context context, ArrayList<Item> dataset) {
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
        holder.mTitle.setText(mDataset.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /* View holder */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView mTitle;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.item_card_view);
            mTitle = (TextView) v.findViewById(R.id.info_text);
        }
    }

}