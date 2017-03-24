package com.application.accessdata.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.application.accessdata.R;
import com.application.accessdata.entity.Message;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CuongNV on 3/24/2017.
 */

public class ItemListChatAdapter extends ArrayAdapter<Message> {
    private Context mContext;
    private ArrayList<Message> messageArrayList = null;

    public ItemListChatAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Message> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.messageArrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        Message message = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (message.isSend()) {
                convertView = inflater.inflate(R.layout.item_list_chat_by_me, null);
            }else {
                convertView = inflater.inflate(R.layout.item_list_chat_not_by_me, null);
            }
            viewHolder = new ViewHolder();
            viewHolder.avata = (RoundedImageView) convertView.findViewById(R.id.avata_user);
            viewHolder.userName = (TextView) convertView.findViewById(R.id.block_user_name);
            viewHolder.chatContent = (TextView) convertView.findViewById(R.id.block_content_item_chat);
            viewHolder.time = (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.userName.setText(message.getUserName());
        viewHolder.chatContent.setText(message.getMessage());
        viewHolder.time.setText(message.getTimePostMessage() + "");

        return convertView;
    }

    public int getCount() {
        return messageArrayList.size();
    }

    private static class ViewHolder {
        private RoundedImageView avata;
        private TextView userName;
        private TextView chatContent;
        private TextView time;
    }
}