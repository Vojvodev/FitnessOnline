package etf.ip.dto;

import java.io.Serializable;

public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String image;
	
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name, String image) {
		super();
		this.name = name;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
