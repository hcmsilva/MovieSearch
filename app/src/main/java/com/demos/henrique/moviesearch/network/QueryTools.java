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

    public static URL urlBuilder(String title, String type, int year, int page, Context ctx)
    {

        String baseUrl = ctx.getString(R.string.base_query_url);
        String baseSearch="s=";
        String titleEncoded="";
        try {
            titleEncoded = URLEncoder.encode(title,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String baseYear="&y=";
        String baseType="&type=";
        String returnType="&r=json";
        String basePage="&page=";

        String url = baseUrl+baseSearch+titleEncoded+baseYear+/*year+*/baseType+type+returnType+basePage+page;

        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

        return null;
    }
}
