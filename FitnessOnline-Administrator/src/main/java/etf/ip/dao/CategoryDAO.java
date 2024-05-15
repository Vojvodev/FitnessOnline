package etf.ip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import etf.ip.dto.Category;


public class CategoryDAO {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_SELECT_ALL 	= "SELECT * FROM categories";
	private static final String SQL_INSERT 		= "INSERT INTO categories (name, image) VALUES (?,?)";
	private static final String SQL_UPDATE 		= "UPDATE categories SET name=?, image=? WHERE id=?";
	private static final String SQL_DELETE 		= "DELETE FROM categories WHERE id=?";
	
	
	public static ArrayList<Category> selectAll(){
		ArrayList<Category> categoryList = new ArrayList<Category>();
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false);
			rs = pstmt.executeQuery();
			while (rs.next()){
				categoryList.add( new Category(rs.getString("name"), rs.getString("image")) );
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return categoryList;
	}
	
	
	public static boolean update(Category category) {
		boolean result = false;
		Connection connection = null;
		Object values[] = { category.getName(), category.getImage(), category.getId() };
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
	
	
	public static boolean insert(Category category) {
		boolean result = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		Object values[] = { category.getName(), category.getImage() };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT, true, values);
			pstmt.executeUpdate();
			generatedKeys = pstmt.getGeneratedKeys();
			if(pstmt.getUpdateCount()>0) {
				result = true;
			}
			if (generatedKeys.next())
				category.setId(generatedKeys.getInt(1));
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
