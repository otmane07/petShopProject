package beans;


public class Order {

	private int order_id;
	private int client_id;
	private int product_id;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int order_id, int client_id, int product_id) {
		super();
		this.order_id = order_id;
		this.client_id = client_id;
		this.product_id = product_id;
	}

	
}
