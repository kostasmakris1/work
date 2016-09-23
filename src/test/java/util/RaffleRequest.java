package util;

import com.google.gson.annotations.Expose;
import model.RaffleBuilder;


public class RaffleRequest {

	@Expose
	private RaffleBuilder raffleBuilder;


	public RaffleBuilder getRaffleBuilder() {
		return raffleBuilder;
	}

	public void setRaffleBuilder(RaffleBuilder raffleBuilder) {
		this.raffleBuilder = raffleBuilder;
	}


}
