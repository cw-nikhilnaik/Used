package com.example.used;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<UsedCarDetails> usedCarDetailsList = new ArrayList<>();
    private RecylerContentAdapter recylerContentAdapter;
    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        Context context = this;

        recylerContentAdapter = new RecylerContentAdapter(context, usedCarDetailsList);
        recyclerView.setAdapter(recylerContentAdapter);

        fetchUsedCarDetails(currentPage);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                currentPage = currentPage +1;
                fetchUsedCarDetails(currentPage);
            }
        });



    }

    private void fetchUsedCarDetails(int currentPage){
        UsedCarListInterface usedCarListInterface = RetrofitClient.getRetrofitInstance().create(UsedCarListInterface.class);
        RequestBody requestBody = new RequestBody(currentPage, 1);
        Call<Used> call = usedCarListInterface.getUserInformation(requestBody);
        call.enqueue(new Callback<Used>() {
            @Override
            public void onResponse(Call<Used> call, Response<Used> response) {
//                Log.e(TAG, "onResponse: " + response. );
                Log.e(TAG, "onResponse: " + response.body().getNextPageUrl() );
                List<UsedCarDetails> newItems= response.body().getStocks();

                usedCarDetailsList.addAll(newItems);
                recylerContentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Used> call, Throwable throwable) {
                Log.e(TAG, "onFailure: " + throwable.getMessage() );
            }
        });
    }
}