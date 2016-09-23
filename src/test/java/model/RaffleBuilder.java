package model;

import com.google.gson.annotations.Expose;
import util.RaffleRequest;

/**
 * Created by c1766077 on 22/06/16.
 */
public class RaffleBuilder extends RaffleRequest {

	@Expose
	private  String name;
	@Expose
	private  String code;
	@Expose
	private  Integer numberOfTickets;
	@Expose
	private Integer remainingTickets;
	@Expose
	private  Integer id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public Integer getRemainingTickets() {
		return remainingTickets;
	}

	public void setRemainingTickets(Integer remainingTickets) {
		this.remainingTickets = remainingTickets;
	}







}
