package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Client;

public class ClientDao  {


	public Client regester(Client c) {
		Connection connection = Dao.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO tbl_client (username, password, email, phone, Company, Adrres) VALUES (?,?,?,?,?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPhone());
			ps.setString(5, c.getCompany());
			ps.setString(6, c.getAdrres());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(client_id) AS MAX_ID FROM tbl_client");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				c.setClient_id(rs.getInt("MAX_ID"));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}


	public int login(String client, String pass) {
		int id =-1;
		Connection connection = Dao.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT client_id AS MAX_ID FROM tbl_client where username like ? and  password like ?");
			ps.setString(1, client);
			ps.setString(2, pass);
		
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id=rs.getInt("MAX_ID");
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return id;
	}


	public String select(int id) {
		String name="";
		Connection connection = Dao.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT  username FROM tbl_client where client_id = ?");
			ps.setInt(1, id);
			
		
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				name=rs.getString("username");
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return name;
	}



}

