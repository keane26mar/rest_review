package restaurant_project;

import java.util.ArrayList;
import java.util.Comparator;



public class User {
	
	

	private ArrayList<User> users = new ArrayList<>();
	
	protected int id;
	protected String username;
	protected String password;
	protected String email;
	protected String mobile_number;
    
    public User(int id, String username, String password, String email, String mobile_number) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile_number = mobile_number;
		
	}
    
	public void setid() {
		this.id = id;
	}
	public void setusername() {
		this.username = username;
	}
	public void setpassword() {
		this.password =password;
	}
	public void setemail() {
		this.email = email;
	}
	public void setmobile_number() {
		this.mobile_number = mobile_number;
	}
	
	

	public int getid() {
		return id;
	}	
	public String getusername() {
		return username;
	}
		
	public String getpassword() {
		return password;
	}
		
	public String getemail() {
		return email;
	}
		
	public String getmobile_number() {
		return mobile_number;
	}
	
	
	
}
		