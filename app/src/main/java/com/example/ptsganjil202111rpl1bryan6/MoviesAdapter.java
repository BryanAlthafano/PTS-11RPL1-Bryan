package com.example.ptsganjil202111rpl1bryan6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.moviesHolder> {

    private ArrayList<MoviesModel> listData;
    private Callback callback;

    public MoviesAdapter(ArrayList<MoviesModel> listData, Callback callback) {
        this.listData = listData;
        this.callback = callback;
    }

    public interface Callback {
        void onClick(int position);
    }

    @NonNull
    @Override
    public moviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        moviesHolder holder = new moviesHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull moviesHolder holder, int position) {
        final MoviesModel getData = listData.get(position);
        String name = getData.getName();
        String popularity = getData.getPopularity();
        String releaseDate = getData.getReleaseDate();

        holder.name.setText(name);
        holder.popularity.setText(popularity);
        holder.releaseDate.setText(releaseDate);
        // https://image.tmdb.org/t/p/w500
        Glide.with(holder.image)
                .load("https://image.tmdb.org/t/p/w500"+listData.get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class moviesHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView popularity;
        TextView releaseDate;
        ImageView image;
        RelativeLayout relativeLayout;

        public moviesHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            popularity = itemView.findViewById(R.id.tvPopularity);
            releaseDate = itemView.findViewById(R.id.tvReleaseDate);
            image = itemView.findViewById(R.id.ivImage);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }
    }
}
