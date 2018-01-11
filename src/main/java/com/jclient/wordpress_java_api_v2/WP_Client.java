package com.jclient.wordpress_java_api_v2;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.jclient.wordpress_java_api_v2.posts.Post;
import com.jclient.wordpress_java_api_v2.posts.Posts;

import util.RESTUtil;

/**
 * Hello world!
 *
 */
public class WP_Client 
{
	/**
	 * Base URL of wordpress rest API ex: http://localhost/wordpress/wp-json/wp/v2/
	 */
	private String baseURL;
	
    public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public static void main( String[] args )
    {
		WP_Client wp= new WP_Client("http://localhost/wordpress/wp-json/wp/v2/");
		Posts p;
		try {
			p = wp.getPosts(); 
			System.out.println( "First Post Title: " + p.getPost().get(0).getTitle().getRendered());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
    }
    
    public WP_Client(String baseURL) {
    	this.baseURL = baseURL;
    }
    
    /**
     * @param path is url path to posts after base URL
     * @throws Exception 
     */
    public Posts getPosts() throws Exception {   	
    	RESTUtil restUtil= new RESTUtil();
    	Posts posts =new Posts();
    
    	List<Post> postList= restUtil.sendGetRestJArrayRequest(endPointURL("posts"), null, new TypeToken<List<Post>>(){}.getType());
    	posts.setPost(postList);
    	
    	return posts;   	
    }

	private String endPointURL(String path) {
		// TODO Auto-generated method stub
		return baseURL+path;
	}
    
}
