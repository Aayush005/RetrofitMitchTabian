package com.codingwithmitch.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.codingwithmitch.myapplication.adapter.RecyclerviewAdapter;
import com.codingwithmitch.myapplication.model.Posts;
import com.codingwithmitch.myapplication.network.Endpoints;
import com.codingwithmitch.myapplication.network.RetrofitClientInstance;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Aayush on 18/01/2019.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerviewAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        Endpoints service = RetrofitClientInstance.getRetrofitInstance().create(Endpoints.class);

        Call<List<Posts>> call = service.getAllPosts();
        call.enqueue(new Callback<List<Posts>>() {

            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Posts> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new RecyclerviewAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
