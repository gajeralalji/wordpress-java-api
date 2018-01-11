
package com.jclient.wordpress_java_api_v2.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WpAttachment {

    @SerializedName("href")
    @Expose
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
