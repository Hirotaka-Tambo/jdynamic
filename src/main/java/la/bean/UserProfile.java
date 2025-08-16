package la.bean;

import java.io.Serializable;

/**
 * Servlet implementation class UserProfile
 */

public class UserProfile implements Serializable{
	private String username;
	private String email;
	private String phone;
	
	public UserProfile(){
		
	}
	
	public UserProfile(String username, String email, String phone) {
		super();
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}

