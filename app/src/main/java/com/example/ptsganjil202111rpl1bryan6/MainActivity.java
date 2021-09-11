package com.example.ptsganjil202111rpl1bryan6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MoviesAdapter adapter;
    ArrayList<MoviesModel> dataMovies;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialFavoriteButton imgFavorite;

        recyclerView = findViewById(R.id.rvMovies);
        recyclerView.setHasFixedSize(true);
        AndroidNetworking.initialize(getApplicationContext());
        getData();
    }

    private void getData(){
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/popular?api_key=436265fbd6f13ffa15b3bdf49b3d524c")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: "+ response.toString());
                        {
                            try {
                                dataMovies = new ArrayList<>();
                                JSONArray jsonArray = response.getJSONArray("results");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    dataMovies.add(new MoviesModel(jsonObject.getString("title"),
                                            jsonObject.getString("overview"),
                                            jsonObject.getString("release_date"),
                                            jsonObject.getString("poster_path"),
                                            jsonObject.getString("backdrop_path"),
                                            jsonObject.getString("popularity")));
                                }
                                gridLayoutManager = new GridLayoutManager(MainActivity.this, 1);
                                recyclerView.setLayoutManager(gridLayoutManager);
                                adapter = new MoviesAdapter(dataMovies, new MoviesAdapter.Callback() {
                                    @Override
                                    public void onClick(int position) {
                                        Toast.makeText(MainActivity.this, "Item Clicked", Toast.LENGTH_SHORT).show();
                                        Intent move = new Intent(getApplicationContext(), DetailMovies.class);
                                        MoviesModel show = dataMovies.get(position);
                                        move.putExtra("header", show.getHeader());
                                        move.putExtra("name", show.getName());
                                        move.putExtra("image", show.getImage());
                                        move.putExtra("releaseDate", show.getReleaseDate());
                                        move.putExtra("popularity", show.getPopularity());
                                        move.putExtra("description", show.getDescription());
                                        startActivity(move);
                                    }
                                });
                                recyclerView.setAdapter(adapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    @Override
                    public void onError(ANError error) {
                        Log.d(TAG, "onError: "+ error);
                        // handle error
                    }
                });
    }
}