
package com.jclient.wordpress_java_api_v2.posts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reply_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parent")
    @Expose
    private Integer parent;
    @SerializedName("author")
    @Expose
    private Integer author;
    @SerializedName("author_name")
    @Expose
    private String authorName;
    @SerializedName("author_url")
    @Expose
    private String authorUrl;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("author_avatar_urls")
    @Expose
    private AuthorAvatarUrls authorAvatarUrls;
    @SerializedName("_links")
    @Expose
    private Links__ links;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AuthorAvatarUrls getAuthorAvatarUrls() {
        return authorAvatarUrls;
    }

    public void setAuthorAvatarUrls(AuthorAvatarUrls authorAvatarUrls) {
        this.authorAvatarUrls = authorAvatarUrls;
    }

    public Links__ getLinks() {
        return links;
    }

    public void setLinks(Links__ links) {
        this.links = links;
    }

}
