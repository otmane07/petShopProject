package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Order;

public class OrderDao {
	public List<Order>  getOrders() {
		List<Order> orders = new ArrayList<Order>();

		Connection connection = Dao.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM `order`");
			ResultSet rs = ps.executeQuery();
		

		
			while(rs.next()) {
				Order order = new Order();
				order.setClient_id(rs.getInt("client_id"));
				order.setProduct_id(rs.getInt("product_id"));
				order.setOrder_id(rs.getInt("order_id"));
				
					orders.add(order);	
					
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	
	public void insert(int client_id,int product_id) {
		Connection connection = Dao.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO `order` ( `client_id`, `product_id`) VALUES (?,?)");
			
			ps.setInt(1, client_id);
			ps.setInt(2, product_id);
			ps.executeUpdate();
			System.out.println("insert");
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

