package la.bean;

import java.io.Serializable;

/**
 * Servlet implementation class ItemBean
 */
public class ItemBean implements Serializable{
	private int id;
	private String name;
	private int price;
	
	public ItemBean(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public ItemBean() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}