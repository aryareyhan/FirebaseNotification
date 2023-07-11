package com.example.uas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas.models.Post;
import com.example.uas.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    Context ctx;
    ArrayList<Post> posts;

    public PostAdapter(Context ctx, ArrayList<Post> posts) {
        this.ctx = ctx;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.post_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.postTitle_edt.setText(posts.get(position).getTitle());
        holder.postBody_edt.setText(posts.get(position).getBody());
        holder.postId_edt.setText(posts.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView postTitle_edt, postBody_edt, postId_edt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle_edt = itemView.findViewById(R.id.postTitle);
            postBody_edt = itemView.findViewById(R.id.postBody);
            postId_edt = itemView.findViewById(R.id.postId);
        }
    }
}
