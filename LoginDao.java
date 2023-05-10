package com.Servlets.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.Login;

public class LoginDao {

	public boolean validate(Login login) {

		String query = "select * from login where username=? and password=?";
		try{
			Connection conn = Dao.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());

			ResultSet result = statement.executeQuery();

			if(result.next()) {
				if(result.getString("username").equals(login.getUsername()) && result.getString("password").equals(login.getPassword())) {
					return true;
				}
			}
			result.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
