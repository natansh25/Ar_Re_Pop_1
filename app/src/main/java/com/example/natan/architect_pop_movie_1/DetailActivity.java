package com.example.natan.architect_pop_movie_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.natan.architect_pop_movie_1.model.Result;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private TextView txt_Title;
    private TextView txt_Plot;
    private TextView txt_Rating;
    private TextView txt_Release;
    private ImageView img_Poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txt_Title = findViewById(R.id.title);
        img_Poster = findViewById(R.id.image_poster);
        txt_Plot = findViewById(R.id.plot);
        txt_Rating = findViewById(R.id.rating);
        txt_Release = findViewById(R.id.release);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Result result = getIntent().getParcelableExtra("data");

        txt_Title.setText(result.getTitle());
        txt_Plot.setText(result.getOverview());
        txt_Rating.setText(result.getVoteAverage() + "/10");
        txt_Release.setText(result.getReleaseDate());
        Picasso.with(img_Poster.getContext()).load("https://image.tmdb.org/t/p/w500" + result.getPosterPath()).into(img_Poster);


    }
}
