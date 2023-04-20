import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import com.lor.api.APIException;
import com.lor.api.LORMovieInstance;
import com.lor.api.LORSessionFactory;
import com.lor.api.Movie;

public class home {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
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
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		

	}

}
