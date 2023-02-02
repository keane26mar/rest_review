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


public class rest_collection {
	
//	 ArrayList<Rest> rests = new ArrayList<>();
	  public ArrayList<Rest> rests = new ArrayList<>();
	  public int capacity;
	  
	  public rest_collection() {
		  this.capacity = 20;
		 
	  }
	  
	  public List<Rest> getRests() {
        return rests;
	  }

	    public void addRest(Rest rest) {
	    	if(rests.size() != capacity) {
	    		rests.add(rest);
	    	}
	    }
 	  
	  public List<Rest> findRestByTitle(String title) {
	        List<Rest> result = new ArrayList<>();
	        for (Rest r : rests) {
	            if (r.getTitle().equals(title)) {
	                result.add(r);
	            }
	        }
	        return result;
	    }
	  
	  	  
	  public List<Rest> findRestNotFound(String title) {
		  List<Rest> result2 = new ArrayList<>();
		  for (Rest r : rests) {
	            if (r.getTitle().equals(title)) {
	                result2.add(r);
	            }
		  }
		  return null;
	  }
	  
	  
//	  public ArrayList<Rest> returnAllImage(String image) {
//		  ArrayList<Rest> results =  new ArrayList<>();
//		  for (Rest r :rests) {
//			  if (r.getTitle().equals(title)) {
//	                result2.add(r);
//	            }
//		  }
//		  
//		return rests;
//		  
//	  }
	  
	  
	  public ArrayList<Rest> sortRestsByTitle() {         
	        Collections.sort(rests, Rest.titleComparator);         
	        return rests;     
	    } 
}

