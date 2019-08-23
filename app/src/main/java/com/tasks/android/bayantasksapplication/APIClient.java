package com.tasks.android.bayantasksapplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.tasks.android.bayantasksapplication.Constatnts;

/**
 * Created by Ameen_Kharma on 7/20/2019.
 */


public class APIClient {
    public static  String API_BASE_URL = Constatnts.Base_URL;
    private static Retrofit retrofit = null;
    public String sessionID;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static OkHttpClient client;

    public APIClient( String sID){
        sessionID = sID;
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Cookie",sessionID);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://patient-api-dev.medsolace.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

    }
    public Retrofit getRetrofit(){
        return retrofit;
    }


}

