package JavaBean;

public class Admin {

	private int AdminId;
	private String username;
	private String address;
	private String email;
	private String password ;
	
	public Admin() {
		
	}
	
	
	public Admin(int adminId, String username, String address, String email, String password) {
		super();
		AdminId = adminId;
		this.username = username;
		this.address = address;
		this.email = email;
		this.password = password;
	}


	public int getAdminId() {
		return AdminId;
	}


	public void setAdminId(int adminId) {
		AdminId = adminId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [AdminId=" + AdminId + ", username=" + username + ", address=" + address + ", email=" + email
				+ ", password=" + password + "]";
	}




	
	
	
	
	
	
}
