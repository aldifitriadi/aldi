package com.example.alfhanrf.skripsihehe.network;

import com.example.alfhanrf.skripsihehe.model.bangungedung.Bangunan;
import com.example.alfhanrf.skripsihehe.model.bangungedung.BangunanList;
import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("auth/login")
    Call<JsonObject> login(@Query("user_id") String user_id, @Query("password") String password);

    @POST("auth/logout")
    Call<RequestResponse> logout(
            @Header("Authorization") String token,
            @Header("User-ID") String userid);

    @POST("auth/authenticate")
    Call<RequestResponse> checkLogin(
            @Header("Authorization") String token,
            @Header("User-ID") String userid);


    @GET("DataBangunan/list_bangunan_user")
    Call<BangunanList> getSemuaBangunan(
            @Header("Authorization") String token,
            @Header("User-ID") String userid);

    @POST("DataBangunan/search_bangunan")
    Call<ResponseBody> search(
            @Header("Authorization") String token,
            @Header("User-ID") String userid,
            @Body RequestBody params);

    @DELETE("DataBangunan/hapusdata/{id_bangunan}")
    Call<RequestResponse> deleteBangunan(
            @Header("Authorization") String token,
            @Header("User-ID") String userid,
            @Path("id_bangunan") String id_bangunan);

    @GET("DataBangunan/list_bangunan_surveyor/{user_id}")
    Call<BangunanList> getBangunanSurveyor(
            @Header("Authorization") String token,
            @Header("User-ID") String userid,
            @Path("user_id") String user_id);

    @POST("DataBangunan/masukandata")
    Call<RequestResponse> masukandata(
            @Header("Authorization") String token,
            @Header("User-ID") String userid,
            @Body Bangunan bangunan);

    @PUT("DataBangunan/updatedata/{id_bangunan}")
    Call<RequestResponse> updateBangunan(
            @Header("Authorization") String token,
            @Header("User-ID") String userid,
            @Path("id_bangunan") String id_bangunan,
            @Body Bangunan bangunan);


}
