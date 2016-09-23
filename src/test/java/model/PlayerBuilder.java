package model;


import com.google.gson.annotations.Expose;

public class PlayerBuilder {

	@Expose
	private  Integer id;
	@Expose
	private  String name;
	@Expose
	private  String email;
	@Expose
	private  String dob;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}




}
