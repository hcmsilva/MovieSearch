package com.demos.henrique.moviesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult implements Parcelable
{

    @SerializedName("MovieResult")
    @Expose
    private List<MovieResult> movieResult = null;
    @SerializedName("totalResults")
    @Expose
    private String totalResults;
    @SerializedName("Response")
    @Expose
    private String response;
    public final static Creator<SearchResult> CREATOR = new Creator<SearchResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResult createFromParcel(Parcel in) {
            SearchResult instance = new SearchResult();
            in.readList(instance.movieResult, (MovieResult.class.getClassLoader()));
            instance.totalResults = ((String) in.readValue((String.class.getClassLoader())));
            instance.response = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SearchResult[] newArray(int size) {
            return (new SearchResult[size]);
        }

    }
            ;

    /**
     *
     * @return
     * The movieResult
     */
    public List<MovieResult> getMovieResult() {
        return movieResult;
    }

    /**
     *
     * @param movieResult
     * The MovieResult
     */
    public void setMovieResult(List<MovieResult> movieResult) {
        this.movieResult = movieResult;
    }

    /**
     *
     * @return
     * The totalResults
     */
    public String getTotalResults() {
        return totalResults;
    }

    /**
     *
     * @param totalResults
     * The totalResults
     */
    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    /**
     *
     * @return
     * The response
     */
    public String getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The Response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(movieResult);
        dest.writeValue(totalResults);
        dest.writeValue(response);
    }

    public int describeContents() {
        return 0;
    }

}