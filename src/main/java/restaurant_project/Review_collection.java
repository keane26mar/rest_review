package restaurant_project;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Review_collection {
	
	
//	 ArrayList<Rest> rests = new ArrayList<>();
	  public ArrayList<Review> reviews = new ArrayList<>();
	  public int capacity;
	  
	  public Review_collection() {
		  this.capacity = 20;
//		  rests.add(new Rest(1, "image", "hello", "hello", 1, "hello", "hello"));
		 
	  }
	  
	  public List<Review> getReviews() {
        return reviews ;
	  }

	    public void addReview(Review review) {
	    	if(reviews.size() != capacity) {
	    		reviews.add(review);
	    	}
	    }
	    
	    public void deleteReview(Review review) {
	    	if(reviews.size() != capacity) {
	    		reviews.remove(review);
	    	}
	    }
	    
	    public void updateReview(int i, Review review) {
	    	if(reviews.size() != capacity) {
	    		reviews.set(i,review);
	    	}
	    }
 
	  public Review findReviewByReviewID(int reviewId) {
	    	for (Review s : reviews) { 		      
	            if(s.getReviewId() == (reviewId)) return s;
	       }
	    	return null;
	   }
	  
	  public Review findReviewByIndex(int i) {
	    	return reviews.get(i);
	   }
	  
//	  public ArrayList<Song> sortSongsByTitle() {         
//        Collections.sort(songs, Song.titleComparator);         
//        return songs;     
//    } 
}

