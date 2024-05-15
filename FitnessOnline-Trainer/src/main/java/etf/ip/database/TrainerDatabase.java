package etf.ip.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import etf.ip.model.TrainerBean;

public class TrainerDatabase {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_BY_EMAIL_AND_PASSWORD = "SELECT * FROM trainers WHERE email=? AND password=?";	// NO NEW-LINES IN THE STRING !!!
	private static final String SQL_SELECT_USER_EMAIL_BY_ID = "SELECT * FROM users WHERE id=?";
	
	
	
	public static TrainerBean selectByEmailAndPassword(String email, String password){
		TrainerBean trainer = null;
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {email, password};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = Util.prepareStatement(connection, SQL_SELECT_BY_EMAIL_AND_PASSWORD, false, values);
			rs = pstmt.executeQuery();
			if (rs.next()){
				trainer = new TrainerBean(rs.getString("fname"), rs.getString("lname"), rs.getString("email"), rs.getString("password"));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return trainer;
	}
	
	
	public static String selectUserEmailById(int id){
		String userEmail = "";
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {id};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = Util.prepareStatement(connection, SQL_SELECT_USER_EMAIL_BY_ID, false, values);
			rs = pstmt.executeQuery();
			if (rs.next()){
				userEmail = rs.getString("email");
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return userEmail;
	}
	
}
