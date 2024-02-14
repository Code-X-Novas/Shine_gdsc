package com.example.new_project.fragment;

import com.example.new_project.ImageUploadResponse;
import com.example.new_project.PostCreationResponse;
import com.example.new_project.PostData;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiService {
    @Multipart
    @POST("upload_image_endpoint")
    retrofit2.Call<ImageUploadResponse> uploadImage(@Part MultipartBody.Part image);

    @POST("create_post_endpoint")
    Call<PostCreationResponse> createPost(@Body PostData postData);
}
