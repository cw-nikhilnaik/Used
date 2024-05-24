package com.example.used;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<UsedCardModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<User> call = apiInterface.getUserInformation("Nikhil","Android Dev");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e(TAG, "onResponse: "+ response.body().getJob() );
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {

            }
        });

        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));
        arrayList.add(new UsedCardModel("Thar","8,00,000"));
        arrayList.add(new UsedCardModel("BMW 3-Series 320d","6,00,000"));
        arrayList.add(new UsedCardModel("BMW X1 sDrive20d","10,00,000"));
        arrayList.add(new UsedCardModel("BMW 3-Series 320d Luxury Line","10,00,000"));
        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));
        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));
        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));
        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));
        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));
        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));
        arrayList.add(new UsedCardModel("Mahindra","10,00,000"));

        RecylerContentAdapter recylerContentAdapter = new RecylerContentAdapter(this, arrayList);
        recyclerView.setAdapter(recylerContentAdapter);
    }
}