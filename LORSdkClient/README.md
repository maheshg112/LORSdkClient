
Name:	LORSdkClient
Description: 	This is a sample client for the LORLiblabSdk on how to use the SDK to query the Movies list.

Installation
------------
1. Install the jar file LORLiblabSdk-0.0.1-jar-with-dependencies
2. Add the jar file to the project's classpath


Usage
-----
1. Create an HashMap for storing the Movie API end point URL and API Key using the constants defined in the LORSessionFactory.

2. Pass the HashMap to the method getMovieInstance in LORSessionFactory.

3. LORSessionFactory will output the LORMovieInstance which contains the Movies list and mehtods to query the data.


Below is the sample code
------------------------
			
			InputStream input = new FileInputStream("Properties/config.properties");
			
			Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            String movieURL = prop.getProperty("MOVIE_API_URL");
            String apiKey = prop.getProperty("API_KEY");
            String movieID = prop.getProperty("EXAMPLE_MOVIE_ID");
            
            HashMap<String, String> params = new HashMap<String, String>();
    		params.put(LORSessionFactory.MOVIE_API_URL, movieURL);
    		params.put(LORSessionFactory.API_KEY, apiKey);
    		LORMovieInstance lorMovieInstance;
            
					
			lorMovieInstance = LORSessionFactory.getMovieInstance(params);
			
			Movie movie = lorMovieInstance.getMovie(movieID);
			
			if(movie != null) {
				System.out.println("Movie Found = " + movie.name);
			}
			else {
				System.out.println("No such movie exists");
			}
			
			
			