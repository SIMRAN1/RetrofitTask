package com.redcarpet.in.retrofittask;

/**
 * Created by simran on 5/24/2017.
 */


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("jsonparsetutorial.txt")
    Call<Model> getImage();


}
