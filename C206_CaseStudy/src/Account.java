
public class Account {

	private String name;
	private String role;
	private String email;
	private String password;
	private String status;
	private Integer contact;
	
	public Account(String name, String role, String email, String password, Integer contact) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.status = "new";
	}

	public Integer getContact() {
		return contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
