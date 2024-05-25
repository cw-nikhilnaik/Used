package com.example.used;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<UsedCarDetails> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UsedCarListInterface usedCarListInterface = RetrofitClient.getRetrofitInstance().create(UsedCarListInterface.class);
        Call<Used> call = usedCarListInterface.getUserInformation("20","198");
        Context context = this;
        call.enqueue(new Callback<Used>() {
            @Override
            public void onResponse(Call<Used> call, Response<Used> response) {
                Log.e(TAG, "onResponse: " + response.body().getStocks() );
                array = response.body().getStocks();
                Log.e(TAG, "onCreate: " + array.get(0).price );

                RecylerContentAdapter recylerContentAdapter = new RecylerContentAdapter(context, array);
                recyclerView.setAdapter(recylerContentAdapter);
            }

            @Override
            public void onFailure(Call<Used> call, Throwable throwable) {
                Log.e(TAG, "onFailure: " + throwable.getMessage() );
            }
        });

    }
}