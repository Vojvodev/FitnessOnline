package etf.ip.model;

import java.io.Serializable;

public class TrainerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fname;
	private String lname;
	private String email;
	private String password;
	private boolean loggedIn = false;
	
	// private List<MessageBean> messageArray = new ArrayList<MessageBean>();		// IN MessageService I loaded all the messages
	
	
	
	public TrainerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerBean(String fname, String lname, String email, String password) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
	}

	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainerBean other = (TrainerBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	
}
