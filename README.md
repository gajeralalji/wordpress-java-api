# wordpress-java-api
This is Java API for wordpress built using gson library to use wordpress's REST API. use WP_Client object to call any wordpress REST operation.

* Simply use WP_Client class, initialize with your base wordpress URL and call methods.



               WP_Client wp = new WP_Client("http://localhost/wordpress/wp-json/wp/v2/");
		try {
			System.out.println("First Post Title: " + wp.getPosts().getPost().get(0).getTitle().getRendered());
			System.out.println("First Post Title: " + wp.getPostById("1").getTitle().getRendered());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
