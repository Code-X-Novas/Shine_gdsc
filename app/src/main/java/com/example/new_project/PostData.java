package com.example.new_project;

public class PostData {
    private String imageUrl;
    private String caption;

    public PostData(String imageUrl, String caption) {
        this.imageUrl = imageUrl;
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCaption() {
        return caption;
    }
}

