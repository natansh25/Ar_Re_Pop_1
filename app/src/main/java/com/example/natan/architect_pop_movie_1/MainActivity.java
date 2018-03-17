package com.example.natan.architect_pop_movie_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.natan.architect_pop_movie_1.adapter.MovieAdapter;
import com.example.natan.architect_pop_movie_1.api.ApiClient;
import com.example.natan.architect_pop_movie_1.api.ApiInterface;
import com.example.natan.architect_pop_movie_1.api.model.Movie;
import com.example.natan.architect_pop_movie_1.api.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //------------calling Retrofit--------------------

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Movie> call = apiService.getPopularMovies(ApiClient.api_key);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                int statusCode = response.code();
                List<Result> results = response.body().getResults();
                mMovieAdapter = new MovieAdapter(results);
                mRecyclerView.setAdapter(mMovieAdapter);
                mMovieAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });


    }
}
