package com.Servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetTaskDao {

	public GetTaskDao() {

	}
	
	public ResultSet getTask(String username) throws ClassNotFoundException, SQLException {
		String query ="select id,task from tasks where username=?";
		try {
			Connection conn = Dao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}