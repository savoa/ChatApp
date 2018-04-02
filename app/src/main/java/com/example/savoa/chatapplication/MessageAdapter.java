package com.example.savoa.chatapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MITAR on 02-Apr-18.
 */

public class MessageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CustomMessage> messages;

    public MessageAdapter(Context context_par) {
        context = context_par;
        messages = new ArrayList<CustomMessage>();
    }

    public void AddCharacter(CustomMessage model){
        messages.add(model);
        notifyDataSetChanged();
    }

    public void RemoveCharacter(CustomMessage model){
        messages.remove(model);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        Object rv = null;
        try {
            rv = messages.get(position);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return rv;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convert_view, ViewGroup parent) {
        if(convert_view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convert_view = inflater.inflate(R.layout.message_row, null);

            ViewHolder holder = new ViewHolder();
            holder.message = (TextView) convert_view.findViewById(R.id.item_message_ID);


            convert_view.setTag(holder);
        }

        CustomMessage model = (CustomMessage) getItem(position);
        ViewHolder holder = (ViewHolder) convert_view.getTag();
        holder.message.setText(model.message);
        if(model.sending) {
            holder.message.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.message.setGravity(Gravity.CENTER_VERTICAL | Gravity.END);
        }
        else {
            holder.message.setBackgroundColor(Color.parseColor("#b7b3b3"));
            holder.message.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
        }


        return convert_view;
    }

    private class ViewHolder {
        public TextView message = null;
    }
}





