package com.example.movievolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class CharacterActivity extends AppCompatActivity implements CharacterAdapter.ClickedItem1 {
   private RecyclerView recyclerView1;
    private ResultsItem resultsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        Intent intent = getIntent();
        resultsItem = (ResultsItem) intent.getParcelableExtra("data");
        List<String> usename = resultsItem.getCharacters();
        recyclerView1 = findViewById(R.id.recyclerview1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        CharacterAdapter adapter = new CharacterAdapter(new CharacterAdapter.ClickedItem1() {
            @Override
            public void ClickedUser(CharecterDetails charecterDetails) {
                Log.e("clicked user", String.valueOf(charecterDetails.getName()));
                Intent myIntent = new Intent(CharacterActivity.this, CharacterHistory.class).putExtra("Data",charecterDetails);
                CharacterActivity.this.startActivity(myIntent);
            }

        });
        adapter.setData(usename);
        recyclerView1.setAdapter(adapter);
    }

    @Override
    public void ClickedUser(CharecterDetails charecterDetails) {

    }
}
