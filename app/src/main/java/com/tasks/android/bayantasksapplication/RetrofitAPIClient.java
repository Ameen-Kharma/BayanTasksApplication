package com.tasks.android.bayantasksapplication;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ameen_Kharma on 7/27/2019.
 */

public class RetrofitAPIClient {

    public static  String API_BASE_URL = "http://patient-api-dev.medsolace.com/api/v1/";
    private static Retrofit retrofit = null;
    public String sessionID;
    APIInterface apiInterface;
    Gson gson;


    public RetrofitAPIClient() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://patient-api-dev.medsolace.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiInterface = retrofit.create(APIInterface.class);
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

}
