package com.example.alfhanrf.skripsihehe.network;

import com.example.alfhanrf.skripsihehe.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alfhanrf on 8/15/2018.
 */


public class APIClient implements Interceptor {
    private static Retrofit retrofit = null;


    public static Retrofit getClientAuthorize() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new APIClient())
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URI)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                .header("Client-Service", "frontend-client")
                .header("Auth-Key", "simplerestapi")
                .build();
        return chain.proceed(authenticatedRequest);
    }
}
