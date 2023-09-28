package com.classjob.retrofitwithpicasso;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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

        View view = LayoutInflater.from(context).inflate(R.layout.product_item_layout, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapters.ViewHolder holder, int position) {

        //convert price to int
        double pricecon = dataModels.get(position).getPrice();
        int intprice = (int) pricecon;
        holder.name.setText(dataModels.get(position).getTitle());
        holder.productprice.setText("Price: " + intprice + " USD");
        holder.stock.setText("Stock: " + dataModels.get(position).getStock());
        holder.rating.setText("" + dataModels.get(position).getRating());
        //show image using picasso
        String imageUrl = dataModels.get(position).getThumbnail();
        Picasso.get().load(imageUrl).into(holder.productimage);


        //setonclick listener to linearlayout for sent id to products details page
        holder.linearLayout.setOnClickListener(v -> {
            Intent intentsent = new Intent(context, ProductDetails.class);
            intentsent.putExtra("id", dataModels.get(position).getId() + "");
            intentsent.putExtra("proname", dataModels.get(position).getTitle().toString());

            context.startActivity(intentsent);


            //   Toast.makeText(context, "clicked on"+dataModels.get(position).getId(), Toast.LENGTH_SHORT).show();
        });


    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, productprice, rating, stock;
        LinearLayout linearLayout;
        ImageView productimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.productname);
            productprice = itemView.findViewById(R.id.productprice);
            productimage = itemView.findViewById(R.id.productimage);
            linearLayout = itemView.findViewById(R.id.productcontainer);
            rating = itemView.findViewById(R.id.productrating);
            stock = itemView.findViewById(R.id.productstock);


        }
    }
}
