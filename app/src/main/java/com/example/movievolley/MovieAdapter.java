package com.example.movievolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private Context context;
    private ClickedItem clickedItem;
    private List<ResultsItem> movieList;
    public void setData(List<ResultsItem> userResponseList) {
        this.movieList = userResponseList;
        notifyDataSetChanged();
    }
    public MovieAdapter(Context context, List<ResultsItem> movies,ClickedItem clickedItem) {
        this.context = context;
        this.clickedItem=clickedItem;
        movieList = movies;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MovieHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        final ResultsItem movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedUser(movie);
            }
        });

            }
    public interface ClickedItem {
        public void ClickedUser(ResultsItem userResponse);
    }
    @Override
   public int getItemCount() {
        return movieList.size();
    }
    public class MovieHolder extends RecyclerView.ViewHolder {
        TextView title;
      //  ImageView arrow;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_tv);
           // arrow = itemView.findViewById(R.id.arrow_iv);
        }
    }
}
