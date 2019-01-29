package com.codingwithmitch.myapplication.network;

import com.codingwithmitch.myapplication.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Aayush on 18/01/2019.
 */

public interface Endpoints {

    @GET("/posts")
    Call<List<Posts>> getAllPosts();
}
