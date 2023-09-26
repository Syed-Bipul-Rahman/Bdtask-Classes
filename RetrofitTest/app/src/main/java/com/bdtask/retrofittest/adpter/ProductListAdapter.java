package com.bdtask.retrofittest.adpter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bdtask.retrofittest.R;
import com.bdtask.retrofittest.Second;
import com.bdtask.retrofittest.models.all_products.AllProductsModel;
import com.bdtask.retrofittest.models.all_products.ResponseObject;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    ArrayList<ResponseObject> listdata = new ArrayList<ResponseObject>();
    Activity activity;


    public ProductListAdapter(Activity activity, ArrayList<ResponseObject> myListData) {
        listdata = myListData;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // MyListData myListData = listdata.get(position);


        holder.pName.setText(listdata.get(position).getTitle());
        holder.pPrice.setText(listdata.get(position).getPrice()+" USD");
       // holder.imageView.setImageResource(listdata.get(position).getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Second.class);
                intent.putExtra("_id", listdata.get(position).getId()+"");
                activity.startActivity(intent);
                Toast.makeText(view.getContext(), "click on item: " + listdata.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView pImage;
        public TextView pName;
        public TextView pPrice;
        public RatingBar pRating;

        public RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.pImage = (ImageView) itemView.findViewById(R.id.pImage);
            this.pName = (TextView) itemView.findViewById(R.id.pName);
            this.pPrice = (TextView) itemView.findViewById(R.id.pPrice);
            pRating = (RatingBar) itemView.findViewById(R.id.pRating);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);


        }
    }
}