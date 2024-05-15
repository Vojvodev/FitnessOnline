package etf.ip.service;

import java.io.Serializable;

import etf.ip.model.TrainerBean;
import etf.ip.database.*;

public class TrainerService implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	public TrainerBean loginTrainer(String email, String password){
		if(email == null || password == null){
			return null;
		}

		return TrainerDatabase.selectByEmailAndPassword(email, password);
	}


	
}
