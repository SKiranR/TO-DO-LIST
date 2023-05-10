package com.Servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteTaskDao {

	public DeleteTaskDao() {
		// TODO Auto-generated constructor stub
	}
	public boolean delete(int id) {
		String query = "delete from tasks where id=?";
		try {
			Connection conn = Dao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			int rs = statement.executeUpdate();
			if(rs > 0) {
				conn.close();
				statement.close();
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
