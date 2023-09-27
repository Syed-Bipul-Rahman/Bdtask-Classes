package com.classjob.retrofitwithpicasso;

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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class RecyclerAdapters extends RecyclerView.Adapter<RecyclerAdapters.ViewHolder> {

    Context context;
    List<Product> dataModels;
    ApiInterface apiInterface;

    public RecyclerAdapters(Context context, List<Product> dataModels) {
        this.context = context;
        this.dataModels = dataModels;

        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }


    @NonNull
    @Override
    public RecyclerAdapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.gridlayout, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapters.ViewHolder holder, int position) {

        holder.name.setText(dataModels.get(position).getTitle());
        holder.brand.setText(dataModels.get(position).getBrand());


        //show image using picasso
        String imageUrl = dataModels.get(position).getThumbnail();
        Picasso.get().load(imageUrl).into(holder.productimage);


        //setonclick listener to linearlayout for sent id to products details page
        holder.linearLayout.setOnClickListener(v -> {
            Intent intentsent = new Intent(context, ProductDetails.class);
            intentsent.putExtra("id", dataModels.get(position).getId() + "");
            context.startActivity(intentsent);


            //   Toast.makeText(context, "clicked on"+dataModels.get(position).getId(), Toast.LENGTH_SHORT).show();
        });


    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, brand;
        LinearLayout linearLayout;
        ImageView productimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productname);
            brand = itemView.findViewById(R.id.brandnamee);
            productimage = itemView.findViewById(R.id.productimage);
            linearLayout = itemView.findViewById(R.id.productcontainer);

        }
    }
}
