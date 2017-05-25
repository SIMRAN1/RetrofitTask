package com.redcarpet.in.retrofittask;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.security.AccessController.getContext;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    ArrayList<Worldpopulation> worldpopulation;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Model> call = apiService.getImage();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model>call, Response<Model> response) {
                worldpopulation = response.body().getWorldpopulation();
                Log.d(TAG, "Number of movies received: " + worldpopulation.size()+response.body());
                initViews();
            }


            @Override
            public void onFailure(Call<Model>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
    private void initViews() {

        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getApplicationContext(),2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));

        DataUserSelectAdapter adapter = new DataUserSelectAdapter(getApplicationContext(),worldpopulation);
        recyclerView.setAdapter(adapter);
    }



}


