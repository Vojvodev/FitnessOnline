package etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import etf.ip.dto.Log;


public class LogDAO {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_SELECT_ALL 	= "SELECT * FROM logs";
	private static final String SQL_INSERT 		= "INSERT INTO logs (user, action) VALUES (?,?)";
	
	
	
	// INSERT LOG INTO A TABLE
	public static boolean insertLog(String user, String action) {
		Log log = new Log(user, action);
			
		return LogDAO.insert(log);
	}
	
	
	public static ArrayList<Log> selectAll(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<Log> logList = new ArrayList<Log>();
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false);
			rs = pstmt.executeQuery();
			while (rs.next()){
				Date parsedDate;
				try { 
					parsedDate = dateFormat.parse(rs.getString("created_at"));
					logList.add( new Log(rs.getString("user"), rs.getString("action"), new Timestamp(parsedDate.getTime())) );
				} catch (ParseException e) { e.printStackTrace();}
				
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return logList;
	}
	
	
	private static boolean insert(Log log) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { log.getUser(), log.getAction()};
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
	
}
