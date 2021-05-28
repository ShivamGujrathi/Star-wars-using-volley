package com.example.movievolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.ClickedItem {
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Movie> movieList;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();
        movieList = new ArrayList<Movie>();
        fetchMovies();
    }
    private void fetchMovies() {
        String url = "https://swapi.dev/api/films/";
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    Gson gson = new Gson();
                    final Movie movie = gson.fromJson(response, Movie.class);

                    adapter = new MovieAdapter(MainActivity.this, movie.getResults(), new MovieAdapter.ClickedItem() {
                        @Override
                        public void ClickedUser(ResultsItem userResponse) {
                            Log.e( "ClickedUser: ",userResponse.getCharacters().toString() );
                            Intent myIntent = new Intent(MainActivity.this, CharacterActivity.class).putExtra("data", (Parcelable) userResponse);
                            MainActivity.this.startActivity(myIntent);
                        }
                    });
                    adapter.setData(movie.getResults());
                    recyclerView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
    @Override
    public void ClickedUser(ResultsItem userResponse) {

    }
}