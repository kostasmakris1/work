package model;


import com.google.gson.annotations.Expose;

public class PlayerDetailsBuilder {

	@Expose
	private String dob;
	@Expose
	private String name;
	@Expose
	private String id;
	@Expose
	private String email;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
