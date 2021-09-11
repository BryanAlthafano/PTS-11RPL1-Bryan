package com.example.ptsganjil202111rpl1bryan6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailMovies extends AppCompatActivity {

    ImageView ivDetailHeaderImage;
    ImageView ivDetailImage;
    TextView tvDetailName;
    TextView tvDetailReleaseDate;
    TextView tvPopularity;
    TextView tvDetailDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies);

        ivDetailHeaderImage = (ImageView) findViewById(R.id.ivDetailHeaderImage);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/original"+getIntent().getStringExtra("header"))
                .into(ivDetailHeaderImage);
        ivDetailImage = (ImageView) findViewById(R.id.ivDetailImage);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500"+getIntent().getStringExtra("image"))
                .into(ivDetailImage);
        tvDetailName = (TextView) findViewById(R.id.tvDetailName);
        tvDetailName.setText(getIntent().getStringExtra("name"));
        tvDetailReleaseDate = (TextView) findViewById(R.id.tvDetailReleaseDate);
        tvDetailReleaseDate.setText(getIntent().getStringExtra("releaseDate"));
        tvDetailDescription = (TextView) findViewById(R.id.tvDetailDescription);
        tvDetailDescription.setText(getIntent().getStringExtra("description"));
        tvPopularity = (TextView) findViewById(R.id.tvDetailPopularity);
        tvPopularity.setText(getIntent().getStringExtra("popularity"));
    }
}