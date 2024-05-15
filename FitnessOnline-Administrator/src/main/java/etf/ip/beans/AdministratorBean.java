package etf.ip.beans;

import java.io.Serializable;

import etf.ip.dao.AdministratorDAO;
import etf.ip.dto.Administrator;

public class AdministratorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Administrator admin = new Administrator();
	private boolean isLoggedIn = false;

	
	
	public boolean login(String username, String password) {
		if(username != null && password != null) {
			if ((admin = AdministratorDAO.selectByUsernameAndPassword(username, password)) != null) {
				isLoggedIn = true;
				return true;
			}
		}
		
		return false;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void logout() {
		admin = new Administrator();
		isLoggedIn = false;
	}

	public Administrator getAdministrator() {
		return admin;
	}

	public boolean isUserNameAllowed(String username) {
		return AdministratorDAO.isUserNameUsed(username);
	}
	
	public boolean add(Administrator admin) {
		return AdministratorDAO.insert(admin);
	}

}