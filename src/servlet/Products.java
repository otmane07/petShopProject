package servlet;


import java.util.ArrayList;
import java.util.List;

import beans.Product;



public class Products {
	private List<Product> product=new ArrayList<Product>();

	public Products() {
		super();
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setPet(List<Product> product) {
		this.product = product;
	}
}
