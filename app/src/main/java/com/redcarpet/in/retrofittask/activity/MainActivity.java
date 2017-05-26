package com.redcarpet.in.retrofittask.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.WindowManager;

import com.redcarpet.in.retrofittask.network.ApiClient;
import com.redcarpet.in.retrofittask.networkinterface.ApiInterface;
import com.redcarpet.in.retrofittask.utils.Model;
import com.redcarpet.in.retrofittask.utils.NetworkUtils;
import com.redcarpet.in.retrofittask.R;
import com.redcarpet.in.retrofittask.utils.Worldpopulation;
import com.redcarpet.in.retrofittask.adapter.DataCountrySelectAdapter;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    ArrayList<Worldpopulation> worldpopulation;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        if(NetworkUtils.isNetConnected(this)) {


            final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);
            ApiInterface apiService =
                    ApiClient.getClient().create(ApiInterface.class);

            Call<Model> call = apiService.getImage();
            call.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {
                    worldpopulation = response.body().getWorldpopulation();
                    Log.d(TAG, "Number of movies received: " + worldpopulation.size() + response.body());
                    loading.dismiss();
                    initViews();
                }


                @Override
                public void onFailure(Call<Model> call, Throwable t) {
                    // Log error here since request failed
                    alertDialog("Error", "Sorry, your device isn't connected to internet");
                    Log.e(TAG, t.toString());
                }
            });
        }
        else
        {
            alertDialog("Error", "Sorry, your device isn't connected to internet");
        }
    }
    private void initViews() {

        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getApplicationContext(),2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));

        DataCountrySelectAdapter adapter = new DataCountrySelectAdapter(getApplicationContext(),worldpopulation,this);
        recyclerView.setAdapter(adapter);
    }
    public void alertDialog(String title, String message) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_WIFI_SETTINGS);
                        startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onDestroy();
                    }
                });
        alertDialog.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().popBackStack();
    }
}


