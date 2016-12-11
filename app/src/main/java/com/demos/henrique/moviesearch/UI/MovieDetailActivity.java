package com.demos.henrique.moviesearch.UI;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.demos.henrique.moviesearch.R;
import com.demos.henrique.moviesearch.model.MovieDetail;
import com.demos.henrique.moviesearch.model.MovieResult;
import com.demos.henrique.moviesearch.network.CustomDeserializer;
import com.demos.henrique.moviesearch.network.QueryTools;
import com.demos.henrique.moviesearch.network.VolleyDownloader;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieDetailActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {

    private VolleyDownloader mDownloader;
    private MovieResult movieResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDownloader = new VolleyDownloader(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
        //place short DTO in the screen
        Toast.makeText(this, movieResult.getMainText(), Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onResponse(String response) {

        MovieDetail movieDetail = null;
        try {
            movieDetail = CustomDeserializer.getMovieDetail(response);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        Toast.makeText(this, movieDetail.getPlot(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
