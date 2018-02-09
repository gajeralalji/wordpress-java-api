
package com.jclient.wordpress_java_api_v2.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("medium_large")
    @Expose
    private MediumLarge mediumLarge;
    @SerializedName("large")
    @Expose
    private Large large;
    @SerializedName("twentyseventeen-featured-image")
    @Expose
    private TwentyseventeenFeaturedImage twentyseventeenFeaturedImage;
    @SerializedName("twentyseventeen-thumbnail-avatar")
    @Expose
    private TwentyseventeenThumbnailAvatar twentyseventeenThumbnailAvatar;
    @SerializedName("full")
    @Expose
    private Full full;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public MediumLarge getMediumLarge() {
        return mediumLarge;
    }

    public void setMediumLarge(MediumLarge mediumLarge) {
        this.mediumLarge = mediumLarge;
    }

    public Large getLarge() {
        return large;
    }

    public void setLarge(Large large) {
        this.large = large;
    }

    public TwentyseventeenFeaturedImage getTwentyseventeenFeaturedImage() {
        return twentyseventeenFeaturedImage;
    }

    public void setTwentyseventeenFeaturedImage(TwentyseventeenFeaturedImage twentyseventeenFeaturedImage) {
        this.twentyseventeenFeaturedImage = twentyseventeenFeaturedImage;
    }

    public TwentyseventeenThumbnailAvatar getTwentyseventeenThumbnailAvatar() {
        return twentyseventeenThumbnailAvatar;
    }

    public void setTwentyseventeenThumbnailAvatar(TwentyseventeenThumbnailAvatar twentyseventeenThumbnailAvatar) {
        this.twentyseventeenThumbnailAvatar = twentyseventeenThumbnailAvatar;
    }

    public Full getFull() {
        return full;
    }

    public void setFull(Full full) {
        this.full = full;
    }

}
