package beans;

import java.io.Serializable;

public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int client_id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String Company;
	private String Adrres;

	
	public Client( String username, String password, String email, String phone, String company,
			String adrres) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		Company = company;
		Adrres = adrres;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getAdrres() {
		return Adrres;
	}

	public void setAdrres(String adrres) {
		Adrres = adrres;
	}
    
	
	
}

