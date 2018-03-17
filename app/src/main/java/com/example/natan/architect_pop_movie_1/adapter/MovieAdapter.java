package com.example.natan.architect_pop_movie_1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.natan.architect_pop_movie_1.R;
import com.example.natan.architect_pop_movie_1.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by natan on 3/17/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Result> mResults;

    public MovieAdapter(List<Result> results) {
        mResults = results;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Result result = mResults.get(position);
        Context context = holder.img.getContext();
        Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + result.getPosterPath()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
        }
    }

}
