package com.example.myapplicationmovie;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load movies from JSON
        List<Movie> movieList = JSONUtility.loadMovies(this);

        if (movieList != null && !movieList.isEmpty()) {
            // Setup Adapter
            MovieAdapter adapter = new MovieAdapter(movieList);
            recyclerView.setAdapter(adapter);
        } else {
            // Handle error or empty list
            Toast.makeText(this, "Failed to load movies or the list is empty.", Toast.LENGTH_LONG).show();
        }
    }
}
