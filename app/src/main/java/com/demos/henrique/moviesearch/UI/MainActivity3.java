package com.demos.henrique.moviesearch.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.demos.henrique.moviesearch.R;
import com.demos.henrique.moviesearch.UI.adapters.CustomAdapter;
import com.demos.henrique.moviesearch.UI.adapters.aux.DataGetter;
import com.demos.henrique.moviesearch.UI.adapters.aux.OnItemClickListener;
import com.demos.henrique.moviesearch.model.MovieResult;
import com.demos.henrique.moviesearch.network.CustomDeserializer;
import com.demos.henrique.moviesearch.network.QueryTools;
import com.demos.henrique.moviesearch.network.VolleyDownloader;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity
        implements DataGetter, Response.Listener<String>, Response.ErrorListener {

    private SearchView mSearchView;
    private RecyclerView mRecyclerView;
    private VolleyDownloader mDownloader;
    private int nextPageToLoad = 1;//incremented by loadMore, reset by onqueryTextChanged
    private final int minSearchCharacters = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSearchView = (SearchView)findViewById(R.id.search);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.content_main3);
        mRecyclerView = (RecyclerView)rl.findViewById(R.id.my_recyclerview);
        mSearchView.setIconified(false);

        CustomAdapter<MovieResult> movieResultCustomAdapter =
                new CustomAdapter<>(
                        new ArrayList<MovieResult>(),
                        this,
                        this);

        mRecyclerView.setAdapter(movieResultCustomAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mDownloader = new VolleyDownloader(this);

        mSearchView.setOnQueryTextListener(

                //TODO extract to class
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {

                        if(query.length() > 2 && query.length() < minSearchCharacters)
                            Toast.makeText(MainActivity3.this,"Please insert "+(minSearchCharacters-query.length())+" characters", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {


                        if(mDownloader != null)
                            mDownloader.cancelPendingRequests();

                        if(newText.length() > 2 && newText.length() < minSearchCharacters)
                            Toast.makeText(MainActivity3.this,"Please insert "+(minSearchCharacters-newText.length())+" characters", Toast.LENGTH_SHORT).show();
                        else if(newText.length() > 2 && !newText.endsWith(" "))
                        {
                            resetAndMakeNewQuery();
                        }
                        return true;
                    }
                }
        );





    }

    private void resetAndMakeNewQuery() {

        String queryUrl = "";
        try {
            queryUrl = QueryTools.searchUrlBuilder(mSearchView.getQuery().toString(),"movie",-1, nextPageToLoad, this).toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        nextPageToLoad = 1;

        ((CustomAdapter)mRecyclerView.getAdapter()).resetDataSet();
        mDownloader.makeStringRequest(
                queryUrl,
                MainActivity3.this,
                MainActivity3.this);
    }


    public VolleyDownloader getmDownloader() {
        return mDownloader;
    }

    @Override
    public void getNextPage() {

        try {

            mDownloader.makeStringRequest(
                    QueryTools.searchUrlBuilder( mSearchView.getQuery().toString(),"movie",-1, nextPageToLoad, this).toString(),
                    MainActivity3.this,
                    MainActivity3.this);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return;
    }

    @Override
    public void onResponse(String response) {

        try {

            List<MovieResult> data = CustomDeserializer.getMovies(response);

            if(data == null)
                return;

            /*if(((CustomAdapter)mRecyclerView.getAdapter()).getDataSet().isEmpty())
                ((CustomAdapter)mRecyclerView.getAdapter()).setDataSet(data);
            else*/

            int oldItemCount = ((CustomAdapter)mRecyclerView.getAdapter()).getDataSet().size();
            ((CustomAdapter)mRecyclerView.getAdapter()).getDataSet().addAll(data);

            mRecyclerView.getAdapter().notifyItemRangeInserted(oldItemCount, data.size());

            nextPageToLoad++;

        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        error.printStackTrace();
    }
}
