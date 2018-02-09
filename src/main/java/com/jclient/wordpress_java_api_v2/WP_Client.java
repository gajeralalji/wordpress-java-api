package com.jclient.wordpress_java_api_v2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.jclient.wordpress_java_api_v2.posts.Post;
import com.jclient.wordpress_java_api_v2.posts.Posts;
import com.jclient.wordpress_java_api_v2.users.User;
import com.jclient.wordpress_java_api_v2.users.Users;

import util.RESTUtil;

/**
 * Hello world!
 *
 */
public class WP_Client {
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

	public static void main(String[] args) {
		WP_Client wp = new WP_Client("http://localhost/wordpress/wp-json/wp/v2/");
		try {
			System.out.println("First Post Title: " + wp.getPosts(false).getPost().get(0).getTitle().getRendered());
			System.out.println("First Post Title: " + wp.getPostById("1",true).getTitle().getRendered());
			Map<String, String>  criteria = new HashMap<String, String>();
			criteria.put("per_page", "3");
			System.out.println("filtered "+wp.getFilteredPosts(criteria,true).getPost().size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WP_Client(String baseURL) {
		this.baseURL = baseURL;
	}

	/**
	 * Method to retrive all the posts
	 * @param embeded if true returns extra elements where embeded is supported
	 * @return Posts
	 * @throws Exception
	 */
	public Posts getPosts(boolean embeded) throws Exception {
		RESTUtil restUtil = new RESTUtil();
		Posts posts = new Posts();
		List<Post> postList = restUtil.sendGetRestJArrayRequest(endPointURL(embeded? "posts?_embed" : "posts"), null,
				new TypeToken<List<Post>>() {
				}.getType());
		posts.setPost(postList);

		return posts;
	}
	
	/**
	 * Method to retrive all the posts with applied filter parameter like per_page =2 
	 * @param criteria : send map with key value pair like criteria.add("per_page","2") info https://developer.wordpress.org/rest-api/reference/posts/#arguments
	 * @return Posts
	 * @throws Exception
	 */
	public Posts getFilteredPosts(Map<String, String>  criteria, boolean embeded) throws Exception {
		RESTUtil restUtil = new RESTUtil();
		Posts posts = new Posts();
		if(embeded)
			criteria.put("_embed", "true");
		List<Post> postList = restUtil.sendGetRestJArrayRequest(endPointURL("posts"), criteria,
				new TypeToken<List<Post>>() {
				}.getType());
		posts.setPost(postList);

		return posts;
	}

	/**
	 * Mrthod to retrive post by id
	 * 
	 * @param id
	 *            : Pass id of the post to search
	 * @throws Exception
	 */
	public Post getPostById(String id, boolean embeded) throws Exception {
		RESTUtil restUtil = new RESTUtil();
		Post post = restUtil.sendGetRestRequest(endPointURL("posts/" + id + (embeded? "?_embed" : "")), null, Post.class);
		return post;
	}
	
	/**
	 * Mrthod to delete post by id
	 * 
	 * @param id
	 *            : Pass id of the post to search
	 * @throws Exception
	 */
	public Post deletePostById(String id, String token,boolean embeded) throws Exception {
		RESTUtil restUtil = new RESTUtil();
		Post post = restUtil.sendDeleteRestRequest(endPointURL("posts/" + id + (embeded? "?_embed" : "")), null, Post.class,token);
		return post;
	}
	
	
	//****** Users *********//
	/**
	 * Method to retrive all the users
	 * 
	 * @return Users
	 * @throws Exception
	 */
	public Users getUsers() throws Exception {
		RESTUtil restUtil = new RESTUtil();
		Users users = new Users();
		List<User> userList = restUtil.sendGetRestJArrayRequest(endPointURL("users"), null,
				new TypeToken<List<User>>() {
				}.getType());
		users.setUser(userList);

		return users;
	}
	
	/**
	 * Method to retrive all the users with applied filter parameter like per_page =2 
	 * @param criteria : send map with key value pair like criteria.add("per_page","2") info https://developer.wordpress.org/rest-api/reference/users/#arguments
	 * @return Users
	 * @throws Exception
	 */
	public Users getFilteredUsers(Map<String, String>  criteria) throws Exception {
		RESTUtil restUtil = new RESTUtil();
		Users users = new Users();
		List<User> userList = restUtil.sendGetRestJArrayRequest(endPointURL("users"), criteria,
				new TypeToken<List<User>>() {
				}.getType());
		users.setUser(userList);

		return users;
	}

	/**
	 * Mrthod to retrieve user by id
	 * 
	 * @param id
	 *            : Pass id of the user to search
	 * @throws Exception
	 */
	public User getUserById(String id) throws Exception {
		RESTUtil restUtil = new RESTUtil();
		User user = restUtil.sendGetRestRequest(endPointURL("users/" + id), null, User.class);
		return user;
	}
	
	//----- End Users-------

	private String endPointURL(String path) {
		// TODO Auto-generated method stub
		return baseURL + path;
	}

}
