package com.classjob.retrofitwithpicasso.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.classjob.retrofitwithpicasso.CartsActivity;
import com.classjob.retrofitwithpicasso.Product;
import com.classjob.retrofitwithpicasso.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Myholder> {
    Context context;
    ArrayList<Items> arrayList;

    public CartAdapter(Context context, ArrayList<Items> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public CartAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_items_layout, parent, false);
        Myholder myHolder = new Myholder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Myholder holder, int position) {
        holder.brandname.setText(arrayList.get(position).getBrandName());
        holder.recyclerText.setText(arrayList.get(position).getProductName());
        holder.rate.setText(arrayList.get(position).getProductPrice());


        //show image using picasso
        String imageUrl = arrayList.get(position).getProductImage();
        Picasso.get().load(imageUrl).into(holder.recyclerImg);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {

        ImageView recyclerImg;
        TextView recyclerText, rate, brandname;
        LinearLayout linearLayout;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            recyclerImg = itemView.findViewById(R.id.recycle_img);
            recyclerText = itemView.findViewById(R.id.recycle_product_name);
            rate = itemView.findViewById(R.id.recycle_text_price);
            brandname = itemView.findViewById(R.id.recybrandname);


        }
    }
}

