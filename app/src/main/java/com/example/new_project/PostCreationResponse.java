package com.example.new_project;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

public class PostCreationResponse {
    @SerializedName("postId")
    private int postId;

    @SerializedName("message")
    private String message;

    public int getPostId() {
        return postId;
    }

    public String getMessage() {
        return message;
    }
}


