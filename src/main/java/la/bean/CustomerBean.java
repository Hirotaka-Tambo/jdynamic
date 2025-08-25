package la.bean;

import java.io.Serializable;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class CustomerBean
 */
@WebServlet("/CustomerBean")
public class CustomerBean implements Serializable {
	private String name;
	private String address;
	private String tel;
	
	public CustomerBean() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	

}
