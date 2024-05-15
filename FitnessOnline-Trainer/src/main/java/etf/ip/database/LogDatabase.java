package etf.ip.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import etf.ip.model.LogBean;


public class LogDatabase {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_INSERT = "INSERT INTO logs (user, action) VALUES (?,?)";
	
	
	
	// INSERT LOG INTO A TABLE
	public static boolean insertLog(String user, String action) {
		LogBean log = new LogBean(user, action);
			
		return insert(log);
	}
	
	
	private static boolean insert(LogBean log) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { log.getUser(), log.getAction()};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = Util.prepareStatement(connection, SQL_INSERT, false, values);
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
