package restaurant_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserCollection {
	
	private ArrayList<User> users = new ArrayList<>();
	private int capacity;
 
    public UserCollection() {
        this.capacity = 20;
    }
  
    public UserCollection(int capacity) {
        this.capacity = capacity;
    }
    
    public List<User> getUsers() {
        return users ;
	}
    
    public void addUser(User user) {
    	if(users.size() != capacity) {
    		users.add(user);
    	}
    }
    
    public User findUserById(int id) {
    	for (User s : users) { 		      
    		if(s.getid() == (id)) return s;
    		}
    	return null;
   }
    
   public void deleteUser(User user) {
	   if(users.size() != capacity) {
		   users.remove(user);
	   }
   }
   
    
   
    
	
}