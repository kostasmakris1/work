package model;

import com.google.gson.annotations.Expose;

public class Error {

	@Expose
	private String reason;

	public String getReason ()
	{
		return reason;
	}

	public void setReason (String reason)
	{
		this.reason = reason;
	}

}
