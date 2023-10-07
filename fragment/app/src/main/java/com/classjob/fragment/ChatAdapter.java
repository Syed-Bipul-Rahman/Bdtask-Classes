package com.classjob.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    Context context;
    ArrayList<ChatModel> dataModels;

    public ChatAdapter(Context context, ArrayList<ChatModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chats_layout, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatModel chatModel = dataModels.get(position);

        // Bind data to your ViewHolder's views here
        holder.name.setText(chatModel.getName());
        holder.message.setText(chatModel.getMessage());
        holder.time.setText(chatModel.getDate());

        // You can also load an image using a library like Picasso or Glide
        // Example using Picasso:
        // Picasso.get().load(chatModel.getImageUrl()).into(holder.profile);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView name, message, time;
        ImageView profile;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize your views here
            name = itemView.findViewById(R.id.number);
            message = itemView.findViewById(R.id.messgedice);
            time = itemView.findViewById(R.id.timede);
            profile = itemView.findViewById(R.id.chatimage);
        }
    }
}
