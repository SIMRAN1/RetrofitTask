package com.redcarpet.in.retrofittask.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;




public class NetworkUtils {
    public static boolean isNetConnected(Context mcontext) {
        NetworkInfo netInfo = ((ConnectivityManager)mcontext
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }




}
