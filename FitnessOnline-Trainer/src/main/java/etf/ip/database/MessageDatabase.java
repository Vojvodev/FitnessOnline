package etf.ip.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import etf.ip.model.MessageBean;

public class MessageDatabase {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_SELECT_BY_EMAIL = 
														"SELECT * "
														+ "FROM messages "
														+ "JOIN trainers ON messages.trainers_id=trainers.id "
														+ "WHERE trainers.email = ? AND messages.seen=0";
	private static final String SQL_UPDATE_SEEN = "UPDATE messages SET seen=? WHERE id=?";
	
	
	
	
	public static ArrayList<MessageBean> selectByEmail(String email){
		ArrayList<MessageBean> messages = new ArrayList<MessageBean>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {email};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = Util.prepareStatement(connection, SQL_SELECT_BY_EMAIL, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()){
				messages.add(new MessageBean(rs.getInt("id"), rs.getInt("trainers_id"), rs.getInt("senders_id"), rs.getString("content"), rs.getString("created_at")));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return messages;
	}

	
	public static ArrayList<MessageBean> selectByContent(String content){
		String SQL_SELECT_BY_CONTENT = "SELECT * FROM messages WHERE content LIKE '%" + content + "%'";
		
		ArrayList<MessageBean> messages = new ArrayList<MessageBean>();
		Connection connection = null;
		ResultSet rs = null;
		// content = "'%" + content + "%'";
		// Object values[] = {content};
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = Util.prepareStatement(connection, SQL_SELECT_BY_CONTENT, false);
			rs = pstmt.executeQuery();
			while (rs.next()){
				messages.add(new MessageBean(rs.getInt("id"), rs.getInt("trainers_id"), rs.getInt("senders_id"), rs.getString("content"), rs.getString("created_at")));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return messages;
	}
	
	
	public static void updateSeen(boolean seen, int messageId){
		Connection connection = null;
		Object values[] = {seen, messageId};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = Util.prepareStatement(connection, SQL_UPDATE_SEEN, false, values);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
	}
	
}
