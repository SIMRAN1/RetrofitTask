package com.redcarpet.in.retrofittask.networkinterface;

/**
 * Created by simran on 5/24/2017.
 */


import com.redcarpet.in.retrofittask.utils.Model;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("jsonparsetutorial.txt")
    Call<Model> getImage();


}
