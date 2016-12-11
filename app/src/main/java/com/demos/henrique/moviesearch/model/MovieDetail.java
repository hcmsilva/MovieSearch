package com.demos.henrique.moviesearch.model;

/**
 * Created by henrique on 11-12-2016.
 */

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDetail extends MovieResult implements Parcelable
{
    /*
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Year")
    @Expose
    private String year;*/
    @SerializedName("Rated")
    @Expose
    private String rated;
    @SerializedName("Released")
    @Expose
    private String released;
    @SerializedName("Runtime")
    @Expose
    private String runtime;
    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("Writer")
    @Expose
    private String writer;
    @SerializedName("Actors")
    @Expose
    private String actors;
    @SerializedName("Plot")
    @Expose
    private String plot;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Awards")
    @Expose
    private String awards;
    /*@SerializedName("Poster")
    @Expose
    private String poster;*/
    @SerializedName("Metascore")
    @Expose
    private String metascore;
    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;
    @SerializedName("imdbVotes")
    @Expose
    private String imdbVotes;
    /*@SerializedName("imdbID")
    @Expose
    private String imdbID;
    @SerializedName("Type")
    @Expose
    private String type;*/
    @SerializedName("tomatoMeter")
    @Expose
    private String tomatoMeter;
    @SerializedName("tomatoImage")
    @Expose
    private String tomatoImage;
    @SerializedName("tomatoRating")
    @Expose
    private String tomatoRating;
    @SerializedName("tomatoReviews")
    @Expose
    private String tomatoReviews;
    @SerializedName("tomatoFresh")
    @Expose
    private String tomatoFresh;
    @SerializedName("tomatoRotten")
    @Expose
    private String tomatoRotten;
    @SerializedName("tomatoConsensus")
    @Expose
    private String tomatoConsensus;
    @SerializedName("tomatoUserMeter")
    @Expose
    private String tomatoUserMeter;
    @SerializedName("tomatoUserRating")
    @Expose
    private String tomatoUserRating;
    @SerializedName("tomatoUserReviews")
    @Expose
    private String tomatoUserReviews;
    @SerializedName("tomatoURL")
    @Expose
    private String tomatoURL;
    @SerializedName("DVD")
    @Expose
    private String dVD;
    @SerializedName("BoxOffice")
    @Expose
    private String boxOffice;
    @SerializedName("Production")
    @Expose
    private String production;
    @SerializedName("Website")
    @Expose
    private String website;
    @SerializedName("Response")
    @Expose
    private String response;
    public final static Parcelable.Creator<MovieDetail> CREATOR = new Creator<MovieDetail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MovieDetail createFromParcel(Parcel in) {
            MovieDetail instance = new MovieDetail();
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.year = ((String) in.readValue((String.class.getClassLoader())));
            instance.rated = ((String) in.readValue((String.class.getClassLoader())));
            instance.released = ((String) in.readValue((String.class.getClassLoader())));
            instance.runtime = ((String) in.readValue((String.class.getClassLoader())));
            instance.genre = ((String) in.readValue((String.class.getClassLoader())));
            instance.director = ((String) in.readValue((String.class.getClassLoader())));
            instance.writer = ((String) in.readValue((String.class.getClassLoader())));
            instance.actors = ((String) in.readValue((String.class.getClassLoader())));
            instance.plot = ((String) in.readValue((String.class.getClassLoader())));
            instance.language = ((String) in.readValue((String.class.getClassLoader())));
            instance.country = ((String) in.readValue((String.class.getClassLoader())));
            instance.awards = ((String) in.readValue((String.class.getClassLoader())));
            instance.poster = ((String) in.readValue((String.class.getClassLoader())));
            instance.metascore = ((String) in.readValue((String.class.getClassLoader())));
            instance.imdbRating = ((String) in.readValue((String.class.getClassLoader())));
            instance.imdbVotes = ((String) in.readValue((String.class.getClassLoader())));
            instance.imdbID = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoMeter = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoImage = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoRating = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoReviews = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoFresh = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoRotten = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoConsensus = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoUserMeter = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoUserRating = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoUserReviews = ((String) in.readValue((String.class.getClassLoader())));
            instance.tomatoURL = ((String) in.readValue((String.class.getClassLoader())));
            instance.dVD = ((String) in.readValue((String.class.getClassLoader())));
            instance.boxOffice = ((String) in.readValue((String.class.getClassLoader())));
            instance.production = ((String) in.readValue((String.class.getClassLoader())));
            instance.website = ((String) in.readValue((String.class.getClassLoader())));
            instance.response = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public MovieDetail[] newArray(int size) {
            return (new MovieDetail[size]);
        }

    }
            ;

    /**
     *
     * @return
     * The title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The Title
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The year
     */
    @Override
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The Year
     */
    @Override
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return
     * The rated
     */
    public String getRated() {
        return rated;
    }

    /**
     *
     * @param rated
     * The Rated
     */
    public void setRated(String rated) {
        this.rated = rated;
    }

    /**
     *
     * @return
     * The released
     */
    public String getReleased() {
        return released;
    }

    /**
     *
     * @param released
     * The Released
     */
    public void setReleased(String released) {
        this.released = released;
    }

    /**
     *
     * @return
     * The runtime
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     *
     * @param runtime
     * The Runtime
     */
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    /**
     *
     * @return
     * The genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     * The Genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     *
     * @return
     * The director
     */
    public String getDirector() {
        return director;
    }

    /**
     *
     * @param director
     * The Director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     *
     * @return
     * The writer
     */
    public String getWriter() {
        return writer;
    }

    /**
     *
     * @param writer
     * The Writer
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     *
     * @return
     * The actors
     */
    public String getActors() {
        return actors;
    }

    /**
     *
     * @param actors
     * The Actors
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     *
     * @return
     * The plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     *
     * @param plot
     * The Plot
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     *
     * @return
     * The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The Language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The awards
     */
    public String getAwards() {
        return awards;
    }

    /**
     *
     * @param awards
     * The Awards
     */
    public void setAwards(String awards) {
        this.awards = awards;
    }

    /**
     *
     * @return
     * The poster
     */
    @Override
    public String getPoster() {
        return poster;
    }

    /**
     *
     * @param poster
     * The Poster
     */
    @Override
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     *
     * @return
     * The metascore
     */
    public String getMetascore() {
        return metascore;
    }

    /**
     *
     * @param metascore
     * The Metascore
     */
    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    /**
     *
     * @return
     * The imdbRating
     */
    public String getImdbRating() {
        return imdbRating;
    }

    /**
     *
     * @param imdbRating
     * The imdbRating
     */
    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    /**
     *
     * @return
     * The imdbVotes
     */
    public String getImdbVotes() {
        return imdbVotes;
    }

    /**
     *
     * @param imdbVotes
     * The imdbVotes
     */
    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    /**
     *
     * @return
     * The imdbID
     */
    @Override
    public String getImdbID() {
        return imdbID;
    }

    /**
     *
     * @param imdbID
     * The imdbID
     */
    @Override
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    /**
     *
     * @return
     * The type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The Type
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The tomatoMeter
     */
    public String getTomatoMeter() {
        return tomatoMeter;
    }

    /**
     *
     * @param tomatoMeter
     * The tomatoMeter
     */
    public void setTomatoMeter(String tomatoMeter) {
        this.tomatoMeter = tomatoMeter;
    }

    /**
     *
     * @return
     * The tomatoImage
     */
    public String getTomatoImage() {
        return tomatoImage;
    }

    /**
     *
     * @param tomatoImage
     * The tomatoImage
     */
    public void setTomatoImage(String tomatoImage) {
        this.tomatoImage = tomatoImage;
    }

    /**
     *
     * @return
     * The tomatoRating
     */
    public String getTomatoRating() {
        return tomatoRating;
    }

    /**
     *
     * @param tomatoRating
     * The tomatoRating
     */
    public void setTomatoRating(String tomatoRating) {
        this.tomatoRating = tomatoRating;
    }

    /**
     *
     * @return
     * The tomatoReviews
     */
    public String getTomatoReviews() {
        return tomatoReviews;
    }

    /**
     *
     * @param tomatoReviews
     * The tomatoReviews
     */
    public void setTomatoReviews(String tomatoReviews) {
        this.tomatoReviews = tomatoReviews;
    }

    /**
     *
     * @return
     * The tomatoFresh
     */
    public String getTomatoFresh() {
        return tomatoFresh;
    }

    /**
     *
     * @param tomatoFresh
     * The tomatoFresh
     */
    public void setTomatoFresh(String tomatoFresh) {
        this.tomatoFresh = tomatoFresh;
    }

    /**
     *
     * @return
     * The tomatoRotten
     */
    public String getTomatoRotten() {
        return tomatoRotten;
    }

    /**
     *
     * @param tomatoRotten
     * The tomatoRotten
     */
    public void setTomatoRotten(String tomatoRotten) {
        this.tomatoRotten = tomatoRotten;
    }

    /**
     *
     * @return
     * The tomatoConsensus
     */
    public String getTomatoConsensus() {
        return tomatoConsensus;
    }

    /**
     *
     * @param tomatoConsensus
     * The tomatoConsensus
     */
    public void setTomatoConsensus(String tomatoConsensus) {
        this.tomatoConsensus = tomatoConsensus;
    }

    /**
     *
     * @return
     * The tomatoUserMeter
     */
    public String getTomatoUserMeter() {
        return tomatoUserMeter;
    }

    /**
     *
     * @param tomatoUserMeter
     * The tomatoUserMeter
     */
    public void setTomatoUserMeter(String tomatoUserMeter) {
        this.tomatoUserMeter = tomatoUserMeter;
    }

    /**
     *
     * @return
     * The tomatoUserRating
     */
    public String getTomatoUserRating() {
        return tomatoUserRating;
    }

    /**
     *
     * @param tomatoUserRating
     * The tomatoUserRating
     */
    public void setTomatoUserRating(String tomatoUserRating) {
        this.tomatoUserRating = tomatoUserRating;
    }

    /**
     *
     * @return
     * The tomatoUserReviews
     */
    public String getTomatoUserReviews() {
        return tomatoUserReviews;
    }

    /**
     *
     * @param tomatoUserReviews
     * The tomatoUserReviews
     */
    public void setTomatoUserReviews(String tomatoUserReviews) {
        this.tomatoUserReviews = tomatoUserReviews;
    }

    /**
     *
     * @return
     * The tomatoURL
     */
    public String getTomatoURL() {
        return tomatoURL;
    }

    /**
     *
     * @param tomatoURL
     * The tomatoURL
     */
    public void setTomatoURL(String tomatoURL) {
        this.tomatoURL = tomatoURL;
    }

    /**
     *
     * @return
     * The dVD
     */
    public String getDVD() {
        return dVD;
    }

    /**
     *
     * @param dVD
     * The DVD
     */
    public void setDVD(String dVD) {
        this.dVD = dVD;
    }

    /**
     *
     * @return
     * The boxOffice
     */
    public String getBoxOffice() {
        return boxOffice;
    }

    /**
     *
     * @param boxOffice
     * The BoxOffice
     */
    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    /**
     *
     * @return
     * The production
     */
    public String getProduction() {
        return production;
    }

    /**
     *
     * @param production
     * The Production
     */
    public void setProduction(String production) {
        this.production = production;
    }

    /**
     *
     * @return
     * The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param website
     * The Website
     */
    public void setWebsite(String website) {
        this.website = website;
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

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(super.title);
        dest.writeValue(super.year);
        dest.writeValue(rated);
        dest.writeValue(released);
        dest.writeValue(runtime);
        dest.writeValue(genre);
        dest.writeValue(director);
        dest.writeValue(writer);
        dest.writeValue(actors);
        dest.writeValue(plot);
        dest.writeValue(language);
        dest.writeValue(country);
        dest.writeValue(awards);
        dest.writeValue(super.poster);
        dest.writeValue(metascore);
        dest.writeValue(imdbRating);
        dest.writeValue(imdbVotes);
        dest.writeValue(super.imdbID);
        dest.writeValue(super.type);
        dest.writeValue(tomatoMeter);
        dest.writeValue(tomatoImage);
        dest.writeValue(tomatoRating);
        dest.writeValue(tomatoReviews);
        dest.writeValue(tomatoFresh);
        dest.writeValue(tomatoRotten);
        dest.writeValue(tomatoConsensus);
        dest.writeValue(tomatoUserMeter);
        dest.writeValue(tomatoUserRating);
        dest.writeValue(tomatoUserReviews);
        dest.writeValue(tomatoURL);
        dest.writeValue(dVD);
        dest.writeValue(boxOffice);
        dest.writeValue(production);
        dest.writeValue(website);
        dest.writeValue(response);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
