package com.example.myapplicationmovie;

import android.content.Context;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONUtility {
    private static final String TAG = "JSONUtility";
    private static final String FILE_NAME = "movies.json";

    public static List<Movie> loadMovies(Context context) {
        List<Movie> movieList = new ArrayList<>();
        String jsonString;

        try {
            InputStream is = context.getAssets().open(FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Log.e(TAG, "Error reading " + FILE_NAME, e);
            return movieList;
        }

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String title = obj.optString("title");
                int year = obj.optInt("year", -1);
                String genre = obj.optString("genre");
                
                // For simplicity, using ic_launcher_background as a placeholder.
                // In a real app, this might be a dynamic resource lookup or a URL.
                int posterResId = R.drawable.ic_launcher_background;

                if (!title.isEmpty() && year != -1 && !genre.isEmpty()) {
                    movieList.add(new Movie(title, year, genre, posterResId));
                } else {
                    Log.w(TAG, "Skipping invalid movie record at index " + i);
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing JSON data", e);
        }

        return movieList;
    }
}
