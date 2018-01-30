
package com.jclient.wordpress_java_api_v2.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Up {

    @SerializedName("embeddable")
    @Expose
    private Boolean embeddable;
    @SerializedName("post_type")
    @Expose
    private String postType;
    @SerializedName("href")
    @Expose
    private String href;

    public Boolean getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
