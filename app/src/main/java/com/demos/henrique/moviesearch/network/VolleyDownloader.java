package com.demos.henrique.moviesearch.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by henrique on 10-12-2016.
 */

public class VolleyDownloader {



    private static RequestQueue mRequestQueue;
    private Context ctx;
    private final String TAG = "SEARCH";

    public VolleyDownloader(Context ctx)
    {
        this.ctx = ctx;
    }


    public static RequestQueue getmRequestQueue() {
        return mRequestQueue;
    }


    private void initQueue()
    {
        mRequestQueue = Volley.newRequestQueue(ctx);
    }


    public void makeStringRequest(String url, Response.Listener<String> mStringListener, Response.ErrorListener mErrorListener)
    {
        if(mRequestQueue == null)
            initQueue();

        StringRequest strRequest = new StringRequest(Request.Method.GET, url, mStringListener, mErrorListener);
        // Set the tag on the request.
        strRequest.setTag(TAG);

        mRequestQueue.add(strRequest);
    }


    public void makeJsonRequest(String url, Response.Listener<JSONObject> mJsonListener, Response.ErrorListener mErrorListener)
    {
        if(mRequestQueue == null)
            initQueue();

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, mJsonListener, mErrorListener);
        // Set the tag on the request.
        jsonRequest.setTag(url);

        mRequestQueue.add(jsonRequest);
    }


    public void cancelPendingRequests() {
        if (mRequestQueue != null)
            mRequestQueue.cancelAll(TAG);
    }
}
