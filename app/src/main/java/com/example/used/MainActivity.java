package com.example.used;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<UsedCardModel> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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