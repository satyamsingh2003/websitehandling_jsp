package org.studyeasy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.studyeasy.config.DatabaseConfig;
import org.studyeasy.entity.User;

public class UsersModel {
	public List <User> listuser(){
		List<User> listusers = new ArrayList<User>();
		// Connection Object init
		Connection connect = DatabaseConfig.getConnection();
		// 3. Create a statement
		Statement stmt = null;
		// 4. Execute a query
		ResultSet rs = null;
		// create the db query
		String query= "Select * from users";
		try {
			stmt = connect.createStatement();
		 	//Execution of statement
			rs=stmt.executeQuery(query);
			while (rs.next()) {
				listusers.add(new User(rs.getInt("users_id"),rs.getString("username"),rs.getString("email")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listusers;
	}
	public void addUser(User newUser) {
		Connection connect=null;
		PreparedStatement statement = null;
		try {
			connect = DatabaseConfig.getConnection();
			String username= newUser.getUsername();
			String email = newUser.getEmail();
			String query = "insert into users (username,email) values(?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void updateUser(User updatedUser) {
		Connection connect= null;
		PreparedStatement statement = null;
		try {
		connect=DatabaseConfig.getConnection();
		int userId = updatedUser.getUser_id();
		String username = updatedUser.getUsername();
		String email = updatedUser.getEmail();
		String query = "UPDATE users SET username= ?, email= ? WHERE users_id = ?";
		statement = connect.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, email);
		statement.setInt(3, userId);
		int rowsAffected = statement.executeUpdate();
        
        if (rowsAffected > 0) {
            System.out.println("User updated successfully.");
        } else {
            System.out.println("No user found with the provided ID.");
        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(int userId) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
		connect = DatabaseConfig.getConnection();
		String query = "delete from users where users_id=?";
		statement = connect.prepareStatement(query);
		statement.setInt(1, userId);
		statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
