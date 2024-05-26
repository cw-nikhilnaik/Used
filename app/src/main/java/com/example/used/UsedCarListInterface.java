package com.example.used;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UsedCarListInterface {

    @Headers("Content-Type: application/json")
    @POST("/api/stocks/filters/")
    Call<Used> getUserInformation(@Body RequestBody requestBody);
}
