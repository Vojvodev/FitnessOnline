package etf.ip.dto;

import java.io.Serializable;
import java.sql.Timestamp;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String fname;
	private String lname;
	private String username;
	private String email;
	private String password;
	private boolean trainer;
	private String contact;
	private String city;
	private String avatar;
	private Timestamp createdAt;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String fname, String lname, String username, String email, String password, boolean trainer,
			String contact, String city, String avatar) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.trainer = trainer;
		this.contact = contact;
		this.city = city;
		this.avatar = avatar;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isTrainer() {
		return trainer;
	}


	public void setTrainer(boolean trainer) {
		this.trainer = trainer;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	
}
