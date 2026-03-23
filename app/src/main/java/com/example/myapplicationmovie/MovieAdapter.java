package com.example.myapplicationmovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        
        holder.titleTextView.setText(movie.getTitle() != null ? movie.getTitle() : "N/A");
        holder.yearTextView.setText(String.valueOf(movie.getYear()));
        holder.genreTextView.setText(movie.getGenre() != null ? movie.getGenre() : "N/A");
        
        // Using the resource ID from the movie object
        if (movie.getPosterResId() != 0) {
            holder.posterImageView.setImageResource(movie.getPosterResId());
        } else {
            // Fallback to a default launcher icon if no poster is provided
            holder.posterImageView.setImageResource(android.R.drawable.ic_menu_report_image);
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView posterImageView;
        TextView titleTextView;
        TextView yearTextView;
        TextView genreTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImageView = itemView.findViewById(R.id.moviePoster);
            titleTextView = itemView.findViewById(R.id.movieTitle);
            yearTextView = itemView.findViewById(R.id.movieYear);
            genreTextView = itemView.findViewById(R.id.movieGenre);
        }
    }
}
