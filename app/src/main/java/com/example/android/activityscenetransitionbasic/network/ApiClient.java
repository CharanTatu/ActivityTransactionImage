package com.example.android.activityscenetransitionbasic.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

   static String url= "http://10.0.2.2:8080/";//"http://192.168.222.92:8080/";
//String url="https://jsonplaceholder.typicode.com/";

 public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
