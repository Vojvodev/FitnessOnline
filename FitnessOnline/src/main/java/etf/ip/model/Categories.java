package etf.ip.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name="categories")
public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	@Pattern(regexp = "^[a-zA-Z0-9 ]+$")
	private String name;

	@Column(name="image")
	//@Pattern(regexp = "^(?:[a-zA-Z]:|/)?(?:[\\w-]+(?:/[\\w-]+)*)*(?:/[\\w-]+\\.\\w+)?$")
	private String image;
	
	// -------------------------------- RELATIONS -----------------------------------------
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore												// Prevents infinite recursion when casting to JSON
    private List<Programs> programsList;
	
	// ------------------------------------------------------------------------------------
	
	
	
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categories(String name, String image, List<Programs> programsList) {
		super();
		this.name = name;
		this.image = image;
		this.programsList = programsList;
	}

	
	
	public List<Programs> getProgramsList() {
		return programsList;
	}

	public void setProgramsList(List<Programs> programsList) {
		this.programsList = programsList;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
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
		
	
}
