package com.wolf.moviedirectory.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wolf.moviedirectory.Model.Movie;
import com.wolf.moviedirectory.R;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Movie> movieList;
    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
        this.mContext = context;
        movieList = movies;
    }

    @NonNull
    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecyclerViewAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        String logoLink = movie.getLogo();

        holder.title.setText(movie.getTitle());
        holder.category.setText(movie.getCategory());
        Picasso.get().load(logoLink).into(holder.logo);
        holder.year.setText(movie.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView logo;
        TextView year;
        TextView category;

        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            mContext = ctx;

            title = itemView.findViewById(R.id.movieTitleId);
            logo = itemView.findViewById(R.id.movieImageId);
            year = itemView.findViewById(R.id.releaseDateId);
            category = itemView.findViewById(R.id.movieCategoryId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }
}
