package com.demos.henrique.moviesearch.network;

import android.content.Context;

import com.demos.henrique.moviesearch.R;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by henrique on 10-12-2016.
 */

public class QueryTools {


    public static URL searchUrlBuilder(String title, String type, int year, int page, Context ctx) throws UnsupportedEncodingException, MalformedURLException {

        String baseUrl = ctx.getString(R.string.base_query_url);
        String baseSearch="s=";
        String titleEncoded="";
        titleEncoded = URLEncoder.encode(title,"UTF-8");
        String baseYear="&y=";
        String baseType="&type=";
        String returnType="&r=json";
        String basePage="&page=";

        String url = baseUrl+baseSearch+titleEncoded+baseYear+/*year+*/baseType+type+returnType+basePage+page;


        return new URL(url);
    }


    public static URL detailsUrlBuilder(String imdbId, boolean displayTomatoes, Context ctx) throws UnsupportedEncodingException, MalformedURLException {
        String baseUrl = ctx.getString(R.string.base_query_url);
        String encodedId = "";
        String baseImdbId = "i=";
        encodedId = URLEncoder.encode(imdbId,"UTF-8");
        String plot = "&plot=true";
        String baseTomatoes = "&tomatoes=";
        String returnType = "&r=json";

        String url = baseUrl + baseImdbId + encodedId + baseTomatoes + displayTomatoes + plot + returnType;

        return new URL(url);
    }



}
