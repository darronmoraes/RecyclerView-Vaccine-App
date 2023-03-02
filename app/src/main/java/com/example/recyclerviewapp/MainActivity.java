package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // 1 - AdapterView : RecyclerView
    RecyclerView recyclerView;

    // 2 - Data Source
    VaccineModel[] myListData;

    // 3 - Adapter
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        myListData = new VaccineModel[] {
                new VaccineModel("Hepatitis B", R.drawable.vaccine_1),
                new VaccineModel("DTaP", R.drawable.vaccine_2),
                new VaccineModel("Corona", R.drawable.vaccine_3),
                new VaccineModel("Tdap", R.drawable.vaccine_4),
                new VaccineModel("Haemophilus Influenzae", R.drawable.vaccine_5),
                new VaccineModel("Poliovirus", R.drawable.vaccine_6),
                new VaccineModel("Rotavirus", R.drawable.vaccine_7),
                new VaccineModel("Measles", R.drawable.vaccine_8)
        };

        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}