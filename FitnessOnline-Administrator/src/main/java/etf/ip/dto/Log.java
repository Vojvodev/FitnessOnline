package etf.ip.dto;

import java.io.Serializable;
import java.sql.Timestamp;


public class Log implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String user;
	private String action;
	private Timestamp time;
	
	
	
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(String user, String action, Timestamp time) {
		super();
		this.user = user;
		this.action = action;
		this.time = time;
	}
	
	public Log(String user, String action) {
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
