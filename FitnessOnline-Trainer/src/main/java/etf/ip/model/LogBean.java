package etf.ip.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String user;
	private String action;
	private Timestamp time;
	
	
	
	public LogBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogBean(String user, String action, Timestamp time) {
		super();
		this.user = user;
		this.action = action;
		this.time = time;
	}
	
	public LogBean(String user, String action) {
		super();
		this.user = user;
		this.action = action;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}


}