package beans;


public class Product {
	int product_id;
	private String product_description;
	private int product_category_id;
	private String product_images;
	private String product_status;
	private double price;
	private String product_name;
	
	public Product(String product_name, String product_description, int product_category_id, String product_images, String product_status,
			double price) {
		super();
		
		this.product_description = product_description;
		this.product_category_id = product_category_id;
		this.product_images = product_images;
		this.product_status = product_status;
		this.product_name = product_name;
		this.price = price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String pet_name) {
		this.product_name = pet_name;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_category_id;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public int getProduct_category_id() {
		return product_category_id;
	}
	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProduct_images() {
		return product_images;
	}
	public void setProduct_images(String product_images) {
		this.product_images = product_images;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
