package restaurant_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class RestDetails {
	public ArrayList<Rest> rests = new ArrayList<>();
	public int capacity;
	
	public RestDetails() {
		this.capacity = 20;
	}

	public List<Rest> getRests(){
		return rests;
	}
	public void addRest(Rest rest) {
		if(rests.size() != capacity) {
			rests.add(rest);
		}
	}
	
	public Rest findRestById(int restId) {
	    for (Rest s : rests) { 		      
	        if(s.getRestId() == restId) return s;
	    }
	    return null;
	}
	
	public List<Rest> findRestByCategory(String category) {
	    List<Rest> result = new ArrayList<>();
	    for (Rest s : rests) { 		      
	        if(s.getCategory().equals(category)) result.add(s);
	    }
	    return result;
	}

	

}