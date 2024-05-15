package etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import etf.ip.dto.User;


public class UserDAO {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_SELECT_ALL 	= "SELECT * FROM users";
	private static final String SQL_INSERT 		= "INSERT INTO users" + 
												  "(fname, lname, uname, email, password, contact, role, is_trainer, avatar, city) VALUES " +
												  "(?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE 		= "UPDATE users SET fname=?, lname=?, uname=?, email=?, password=?, contact=?, avatar=?, city=? " +
												  "WHERE id=?";
	private static final String SQL_DELETE 		= "DELETE FROM users WHERE id=?";
	
	
	
	public static ArrayList<User> selectAll(){
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false);
			rs = pstmt.executeQuery();
			while (rs.next()){
				userList.add( new User(
										rs.getString("fname"),
										rs.getString("lname"),
										rs.getString("uname"),
										rs.getString("email"),
										rs.getString("password"),
										false,								// TRAINER
										rs.getString("contact"),
										rs.getString("city"),
										rs.getString("avatar")
						) );
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return userList;
	}
	
	
	public static boolean update(User user) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { user.getFname(), user.getLname(), user.getUsername(), user.getEmail(), user.getPassword(),
							user.getContact(), user.getAvatar(), user.getCity(), user.getId() };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_UPDATE, false, values);
			pstmt.executeUpdate();
			if(pstmt.getUpdateCount()>0) {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return result;
	}
	
	
	public static boolean insert(User user) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { user.getFname(), user.getLname(), user.getUsername(), user.getEmail(), user.getPassword(),
							user.getContact(), "LOGGED_USER", false, user.getAvatar(), user.getCity()};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT, false, values);
			pstmt.executeUpdate();
			if(pstmt.getUpdateCount()>0) {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return result;
	}
	
	
	public static boolean delete(int id) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { id };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_DELETE, false, values);
			pstmt.executeUpdate();
			if(pstmt.getUpdateCount()>0) {
				result = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return result;
	}
	
	
}
