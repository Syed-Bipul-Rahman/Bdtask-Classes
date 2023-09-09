package com.classwork.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    Context context;
    ArrayList<Model> arrayList;

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_layout, parent, false);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyHolder holder, int position) {
        holder.recyclerImg.setImageResource(arrayList.get(position).getImage());
        holder.recyclerText.setText(arrayList.get(position).getName());
        holder.rate.setText(arrayList.get(position).getRate());
        holder.linearLayout.setOnClickListener(v -> {


            int image=arrayList.get(position).getImage();
            String price=arrayList.get(position).getRate();
            String name=arrayList.get(position).getName();

            Intent intent=new Intent(context,DetailsActivity.class);
            intent.putExtra("name",name);
            intent.putExtra("price",price);
            intent.putExtra("image",image);


           context.startActivity(intent);


           // Toast.makeText(context, arrayList.get(position).getName().toString(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView recyclerImg;
        TextView recyclerText, rate;
        LinearLayout linearLayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            recyclerImg = itemView.findViewById(R.id.recycle_img);
            recyclerText = itemView.findViewById((R.id.recycle_text));
            linearLayout = itemView.findViewById(R.id.linearlayout);

            rate = itemView.findViewById(R.id.recycle_text_price);


        }
    }
}
