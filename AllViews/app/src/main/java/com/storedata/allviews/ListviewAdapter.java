package com.storedata.allviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(ListViewModel item);
    }


    Context context;
    ArrayList<ListViewModel> dataList = new ArrayList<>();

    public ListviewAdapter(Context context, ArrayList<ListViewModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, null, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.textView1 = convertView.findViewById(R.id.textView1);
            viewHolder.textView2 = convertView.findViewById(R.id.textView2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        ListViewModel item = dataList.get(i);

        // Set data to views
        viewHolder.imageView.setImageResource(item.getImageResourceId());
        viewHolder.textView1.setText(item.getText1());
        viewHolder.textView2.setText(item.getText2());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(item);
                }
            }
        });

        return convertView;

    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }
}
