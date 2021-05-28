package com.example.movievolley;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import java.util.List;
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterHolder> {
    private Context context;
    private List<String> movieList;
    private ClickedItem1 clickedItem1;
    public CharacterAdapter(ClickedItem1 clickedItem1) {
        this.clickedItem1 = clickedItem1;
    }
    public void setData(List<String> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new CharacterHolder(LayoutInflater.from(context).inflate(R.layout.character_name, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final CharacterHolder holder, final int position) {
        final String movie = movieList.get(position);
        fetchMovies(movie, holder.character);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public interface ClickedItem1 {
        public void ClickedUser(CharecterDetails charecterDetails);

    }

    public class CharacterHolder extends RecyclerView.ViewHolder {
        TextView character;

        public CharacterHolder(@NonNull View itemView) {
            super(itemView);
            character = itemView.findViewById(R.id.character_tv);
        }
    }

    private void fetchMovies(String url, final TextView textView) {
        String[] strings = url.split("/");
        String url1 = "https://swapi.dev/api/people/" + strings[strings.length - 1] + "/";
        StringRequest jsonArrayRequest = new StringRequest(Request.Method.GET, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    Gson gson = new Gson();
                    final CharecterDetails movie = gson.fromJson(response, CharecterDetails.class);
                    textView.setText(movie.getName());
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            clickedItem1.ClickedUser(movie);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        VolleySingleton.getmInstance(context).getRequestQueue().add(jsonArrayRequest);
    }
}
