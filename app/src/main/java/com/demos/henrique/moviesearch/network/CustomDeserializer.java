package com.demos.henrique.moviesearch.network;

import android.util.Log;

import com.demos.henrique.moviesearch.model.MovieDetail;
import com.demos.henrique.moviesearch.model.MovieResult;
import com.demos.henrique.moviesearch.model.SearchResult;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by henrique on 09-12-2016.
 */

public class CustomDeserializer {

    public static final String TAG = "CustomDeserializer";

    public static List<MovieResult> getMovies(String jsonPayload) throws JSONException {
        Log.i(TAG, "Parsing stream as List<MovieResult>");


        final SearchResult searchResult = new Gson().fromJson(jsonPayload, SearchResult.class);

        if(!searchResult.getResponse().equals("True"))
            return null;

        JSONObject searchResultJSON = new JSONObject(jsonPayload);
        JSONArray movieResultJsonArr = searchResultJSON.getJSONArray("Search");

        Type listType = new TypeToken<ArrayList<MovieResult>>(){}.getType();
        final List<MovieResult> newEntries = new Gson().fromJson(movieResultJsonArr.toString(), listType);

        Log.i(TAG, "Parsing complete. Found " + newEntries.size() + " entries");

        return newEntries;
    }


    public static MovieDetail getMovieDetail(String json) throws JSONException{
        Log.i(TAG, "Parsing stream as MovieDetail");

        return new Gson().fromJson(json, MovieDetail.class);
    }
}
