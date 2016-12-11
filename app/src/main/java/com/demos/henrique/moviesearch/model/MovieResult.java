package com.demos.henrique.moviesearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.demos.henrique.moviesearch.UI.adapters.aux.DoubleListable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResult implements Parcelable, DoubleListable
{

    @SerializedName("Title")
    @Expose
    protected String title;
    @SerializedName("Year")
    @Expose
    protected String year;
    @SerializedName("imdbID")
    @Expose
    protected String imdbID;
    @SerializedName("Type")
    @Expose
    protected String type;
    @SerializedName("Poster")
    @Expose
    protected String poster;
    public final static Creator<MovieResult> CREATOR = new Creator<MovieResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MovieResult createFromParcel(Parcel in) {
            MovieResult instance = new MovieResult();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.year = ((String) in.readValue((String.class.getClassLoader())));
            instance.imdbID = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.poster = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public MovieResult[] newArray(int size) {
            return (new MovieResult[size]);
        }

    }
            ;

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The Year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return
     * The imdbID
     */
    public String getImdbID() {
        return imdbID;
    }

    /**
     *
     * @param imdbID
     * The imdbID
     */
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     *
     * @param poster
     * The Poster
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(year);
        dest.writeValue(imdbID);
        dest.writeValue(type);
        dest.writeValue(poster);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String getMainText() {
        return getTitle();
    }

    @Override
    public String getSmallText() {
        return getYear();
    }

    @Override
    public String getThumbUrl() {
        return getPoster();
    }

}