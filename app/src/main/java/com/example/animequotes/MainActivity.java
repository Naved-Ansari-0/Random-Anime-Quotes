package com.example.animequotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimeQuotesService animeQuotesService = new AnimeQuotesService(MainActivity.this);
                animeQuotesService.getQuotes(new AnimeQuotesService.VolleyResponseListener() {
                    @Override
                    public void OnError(String message) {
                        Toast.makeText(MainActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void OnResponse(List<Quote> quotes) {
                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, quotes);
                        listView.setAdapter(adapter);
                    }
                });
            }
        });

    }
}