package com.Servlets.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java.CreateAccount;

public class CreateAccountDao {
	
	
	public boolean create(CreateAccount account) {
		String userDetails = "insert into users(full_name,first_name,last_name,email,password) values(?,?,?,?,?)";
		String loginDetails = "insert into login(username,password) values(?,?)";
		try {
			Connection conn = Dao.getConnection();
			
			PreparedStatement statement1 = conn.prepareStatement(userDetails);
			statement1.setString(1, account.getFirstName()+" "+account.getLastName());
			statement1.setString(2, account.getFirstName());
			statement1.setString(3, account.getLastName());
			statement1.setString(4, account.getEmail());
			statement1.setString(5, account.getPassword());
			int rowsAffected1 = statement1.executeUpdate();
			statement1.close();
			
			PreparedStatement statement2 = conn.prepareStatement(loginDetails);
			statement2.setString(1, account.getFirstName() +" "+ account.getLastName());
			statement2.setString(2, account.getPassword());
			int rowsAffected2 = statement2.executeUpdate();
			statement2.close();
			
			conn.close();
			
			if(rowsAffected1 > 0 && rowsAffected2 > 0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
