package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;




public class ProductDao {
	public List<Product>  getProducts() {
		List<Product> products = new ArrayList<Product>();

		Connection connection = Dao.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM tbl_product");
			ResultSet rs = ps.executeQuery();
		

		
			while(rs.next()) {
					Product product = new Product();
					product.setProduct_name(rs.getString("product_name"));
					product.setProduct_id(rs.getInt("product_id"));
					product.setProduct_description(rs.getString("product_description"));
					product.setProduct_category_id(rs.getInt("product_category_id"));
					product.setProduct_images(rs.getString("product_images"));
					product.setProduct_status(rs.getString("product_status"));
					product.setPrice(rs.getDouble("price"));
					products.add(product);	
					
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
