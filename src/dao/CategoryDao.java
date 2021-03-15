package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Category;



public class CategoryDao {
	
	public List<Category>  getCategorys() {
		
		List<Category> categorys = new ArrayList<Category>();

		Connection connection = Dao.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM tbl_product_category");
			ResultSet rs = ps.executeQuery();		
			while(rs.next()) {
					Category category = new Category();
					category.setProduct_category_id(rs.getInt("product_category_id"));
					category.setProduct_category_name(rs.getString("product_category_name"));				
					categorys.add(category);						
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorys;
	}	
}
