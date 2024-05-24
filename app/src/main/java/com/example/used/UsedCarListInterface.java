package com.example.used;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UsedCarListInterface {
    @FormUrlEncoded
    @POST("/api/stocks/filters/")
    Call<Used> getUserInformation(@Field("car") String car, @Field("city") String city);
}
