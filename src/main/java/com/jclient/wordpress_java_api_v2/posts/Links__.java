
package com.jclient.wordpress_java_api_v2.posts;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__ {

    @SerializedName("self")
    @Expose
    private List<Self> self = null;
    @SerializedName("collection")
    @Expose
    private List<Collection> collection = null;
    @SerializedName("author")
    @Expose
    private List<Author> author = null;
    @SerializedName("up")
    @Expose
    private List<Up> up = null;
    @SerializedName("in-reply-to")
    @Expose
    private List<InReplyTo> inReplyTo = null;
    @SerializedName("children")
    @Expose
    private List<Child> children = null;

    public List<Self> getSelf() {
        return self;
    }

    public void setSelf(List<Self> self) {
        this.self = self;
    }

    public List<Collection> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Up> getUp() {
        return up;
    }

    public void setUp(List<Up> up) {
        this.up = up;
    }

    public List<InReplyTo> getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(List<InReplyTo> inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

}
