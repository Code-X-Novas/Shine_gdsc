package com.example.new_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<post> postList;

    public PostAdapter(List<post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        post Post = postList.get(position);
        // Bind post data to views in the ViewHolder
        holder.captionTextView.setText(Post.getText());
        holder.likesTextView.setText("Likes: " + Post.getLikesCount());
        holder.commentsTextView.setText("Comments: " + Post.getCommentsCount());

        holder.likeButton.setOnClickListener(v -> {
            if (!Post.isLiked()) {
                Post.setLikesCount(Post.getLikesCount() + 1);
                Post.setLiked(true);
            } else {
                Post.setLikesCount(Post.getLikesCount() - 1);
                Post.setLiked(false);
            }
            notifyDataSetChanged(); // Update the UI
        });

        // Handle comment button click
        holder.commentButton.setOnClickListener(v -> {
            // Implement logic to add a comment to the post
        });


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView captionTextView;
        TextView likesTextView;
        TextView commentsTextView;
        Button likeButton;
        Button commentButton;



        public PostViewHolder(View view) {
            super(view);
            captionTextView = view.findViewById(R.id.captionTextView);
            likesTextView = view.findViewById(R.id.likesTextView);
            commentsTextView = view.findViewById(R.id.commentsTextView);
            likeButton = view.findViewById(R.id.likeButton);
            commentButton = view.findViewById(R.id.commentButton);
        }
    }
}



