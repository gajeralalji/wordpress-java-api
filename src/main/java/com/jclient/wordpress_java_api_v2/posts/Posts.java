
package com.jclient.wordpress_java_api_v2.posts;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts {

   
    private List<Post> post = null;

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

}
