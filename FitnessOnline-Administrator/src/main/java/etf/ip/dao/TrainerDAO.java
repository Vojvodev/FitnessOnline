package etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import etf.ip.dto.Trainer;


public class TrainerDAO {
private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_SELECT_ALL 	= "SELECT * FROM trainers";
	private static final String SQL_INSERT 		= "INSERT INTO trainers" + 
												  "(fname, lname, email, password) VALUES (?,?,?,?)";
	private static final String SQL_UPDATE 		= "UPDATE trainers SET fname=?, lname=?, email=?, password=? WHERE id=?";
	private static final String SQL_DELETE 		= "DELETE FROM trainers WHERE id=?";
	
	
	
	public static ArrayList<Trainer> selectAll(){
		ArrayList<Trainer> trainerList = new ArrayList<Trainer>();
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false);
			rs = pstmt.executeQuery();
			while (rs.next()){
				trainerList.add(new Trainer(
										rs.getString("fname"),
										rs.getString("lname"),
										rs.getString("email"),
										rs.getString("password")
						) );
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return trainerList;
	}
	
	
	public static boolean update(Trainer trainer) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { trainer.getFname(), trainer.getLname(), trainer.getEmail(), trainer.getPassword(), trainer.getId()};
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
	
	
	public static boolean insert(Trainer trainer) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { trainer.getFname(), trainer.getLname(), trainer.getEmail(), trainer.getPassword()};
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
