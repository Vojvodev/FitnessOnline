package etf.ip.beans;

import java.io.Serializable;

import etf.ip.dto.Category;

public class CategoryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Category category = new Category();

	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
