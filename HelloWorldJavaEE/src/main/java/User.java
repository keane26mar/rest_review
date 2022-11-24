public class User {
	protected String name;
	protected String password;
	protected String email;
	protected String language;
	public User(String name, String password, String email, String language) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.language = language;
	}
	
	public String getName() {
		return name;
	}
	
	/*public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
		public void setEmail(String email) {
		this.email = email;
	}
	
		public void setLanguage(String language) {
		this.language = language;
	}
	
	
	*/
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}

	public String getLanguage() {
		return language;
	}

}