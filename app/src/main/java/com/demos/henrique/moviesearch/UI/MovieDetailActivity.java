package com.demos.henrique.moviesearch.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.demos.henrique.moviesearch.R;
import com.demos.henrique.moviesearch.model.MovieDetail;
import com.demos.henrique.moviesearch.model.MovieResult;
import com.demos.henrique.moviesearch.network.CustomDeserializer;
import com.demos.henrique.moviesearch.network.QueryTools;
import com.demos.henrique.moviesearch.network.VolleyDownloader;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieDetailActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {

    private VolleyDownloader mDownloader;
    private MovieResult movieResult;
    private ImageView thumbnailImage;
    private TextView movieTitleTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        movieTitleTV = (TextView)findViewById(R.id.toolbar_top_title);
        thumbnailImage = (ImageView) findViewById(R.id.toolbar_imageview_inside);

        mDownloader = new VolleyDownloader(this);




        movieResult = getIntent().getParcelableExtra(getString(R.string.movie_result_key));


        //buildQuery
        URL detailsUrl = null;
        try {

            detailsUrl = QueryTools.detailsUrlBuilder(movieResult.getImdbID(), true, this);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



        // load details in another thread
        mDownloader.makeStringRequest(detailsUrl.toString(), this, this);

        movieTitleTV.setText(movieResult.getTitle());


        if(movieResult.getThumbUrl().contains("http"))
            Picasso.with(this).load(movieResult.getThumbUrl())
                    .resize(700,850).centerInside()
                    .into(thumbnailImage);
        else
            Picasso.with(this).load(this.getString(R.string.no_thumbnail_img_url))
                    .resize(350,350)
                    .centerCrop()
                    .into(thumbnailImage);



    }

    @Override
    public void onResponse(String response) {

        MovieDetail movieDetail = null;
        try {
            movieDetail = CustomDeserializer.getMovieDetail(response);

            findAndSetViews(movieDetail);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        Toast.makeText(this, movieDetail.getPlot(), Toast.LENGTH_SHORT).show();
    }

    private void findAndSetViews(MovieDetail movieDetail){


        TextView yearTv = (TextView)findViewById(R.id.year_tv);
        TextView ratedmoviesearchTv= (TextView)findViewById(R.id.rated_tv);
        TextView releasedmoviesearchTv = (TextView)findViewById(R.id.released_tv);
        TextView runtimeTv = (TextView)findViewById(R.id.runtime_tv);
        TextView genreTv = (TextView)findViewById(R.id.genre_tv);
        TextView directorTv = (TextView)findViewById(R.id.director_tv);
        TextView writerTv = (TextView)findViewById(R.id.writer_tv);
        TextView actorsTv = (TextView)findViewById(R.id.actors_tv);
        TextView plotTv = (TextView)findViewById(R.id.plot_tv);
        TextView languageTv = (TextView)findViewById(R.id.language_tv);
        TextView countryTv = (TextView)findViewById(R.id.country_tv);
        TextView awardsTv = (TextView)findViewById(R.id.awards_tv);
        TextView imdbVotesTv = (TextView)findViewById(R.id.imdb_votes_tv);
        TextView imdbRatingTv= (TextView)findViewById(R.id.imdb_rating_tv);
        TextView tomatoRatingTv = (TextView)findViewById(R.id.tomato_rating_tv);
        TextView tomatoNumReviewsTv = (TextView)findViewById(R.id.tomato_num_reviews_tv);
        TextView productionTv = (TextView)findViewById(R.id.production_tv);
        TextView websiteTv = (TextView)findViewById(R.id.website_tv);


        yearTv.setText("Year: "+movieDetail.getYear());
        ratedmoviesearchTv.setText("Rated: "+movieDetail.getRated());
        releasedmoviesearchTv.setText("Released: "+movieDetail.getReleased());
        runtimeTv.setText("Duration: "+movieDetail.getRuntime());
        genreTv.setText("Genre: "+movieDetail.getGenre());
        directorTv.setText("Director: "+movieDetail.getDirector());
        writerTv.setText("Writer: "+movieDetail.getWriter());
        actorsTv.setText("Actors: "+movieDetail.getActors());
        plotTv.setText("Plot: "+movieDetail.getPlot());
        languageTv.setText("Language: "+movieDetail.getLanguage());
        countryTv.setText("Country: "+movieDetail.getCountry());
        awardsTv.setText("Awards: "+movieDetail.getAwards());
        imdbVotesTv.setText("IMDB Votes: "+movieDetail.getImdbVotes());
        imdbRatingTv.setText("IMDB Rating: "+movieDetail.getImdbRating());
        tomatoRatingTv.setText("Tomato Rating: "+movieDetail.getTomatoRating());
        tomatoNumReviewsTv.setText("Tomato Review Count: "+movieDetail.getTomatoReviews());
        productionTv.setText("Production: "+movieDetail.getProduction());
        websiteTv.setText("Website: "+movieDetail.getWebsite());

    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
