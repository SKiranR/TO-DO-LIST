package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Servlets.dao.Dao;

public class GetUserDetails {

	private String user_Full_Name;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String password;
	
	public GetUserDetails() {
		
	}
	
	public String getUser_Full_Name() {
		return user_Full_Name;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setUser_Full_Name(String user_Full_Name) {
		this.user_Full_Name = user_Full_Name;
	}
	
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GetUserDetails getDetails(Login loginDetails) {
		GetUserDetails details = new GetUserDetails();
		String query = "select * from users where full_name=? and password=?";
		try {
			Connection conn = Dao.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, loginDetails.getUsername());
			statement.setString(2, loginDetails.getPassword());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				details.setUser_Full_Name(result.getString("full_name"));
				details.setUserFirstName(result.getString("first_name"));
				details.setUserLastName(result.getString("last_name"));
				details.setUserEmail(result.getString("email"));
				details.setPassword(result.getString("password"));
			}
			result.close();
			statement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return details;
	}
}
