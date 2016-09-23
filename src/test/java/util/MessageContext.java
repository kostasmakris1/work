package util;

import java.util.HashMap;

/**
 * Message Context is used to store data which will be used during test execution
 */
public class MessageContext {

	private int raffleId ;
	private int remainingTickets;
	private String raffleName;
	private String code;
	private RandomDataGen randomDataGen;
	private int playerId;
	private String playerName;
	private String dob;
	private String email;
	private HashMap<String, Integer> players = new HashMap<String, Integer>();
	private int ticketId;
	private int playerIdWithTicket;
	private String reason;
	private String dobPlayerDetails;
	private String emailPlayerDetails;
	private String namePlayerDetails;
	private int numberOfTickets;
	private int errorCode;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public String getDobPlayerDetails() {
		return dobPlayerDetails;
	}

	public void setDobPlayerDetails(String dobPlayerDetails) {
		this.dobPlayerDetails = dobPlayerDetails;
	}

	public String getEmailPlayerDetails() {
		return emailPlayerDetails;
	}

	public void setEmailPlayerDetails(String emailPlayerDetails) {
		this.emailPlayerDetails = emailPlayerDetails;
	}

	public String getNamePlayerDetails() {
		return namePlayerDetails;
	}

	public void setNamePlayerDetails(String namePlayerDetails) {
		this.namePlayerDetails = namePlayerDetails;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getPlayerIdWithTicket() {
		return playerIdWithTicket;
	}

	public void setPlayerIdWithTicket(int playerIdWithTicket) {
		this.playerIdWithTicket = playerIdWithTicket;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public HashMap<String, Integer> getPlayers() {
		return players;
	}

	public void setPlayers(HashMap<String, Integer> players) {
		this.players = players;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public RandomDataGen getRandomDataGen() {
		return randomDataGen;
	}

	public void setRandomDataGen(RandomDataGen randomDataGen) {
		this.randomDataGen = randomDataGen;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getRaffleName() {
		return raffleName;
	}

	public void setRaffleName(String raffleName) {
		this.raffleName = raffleName;
	}


	public int getRemainingTickets() {
		return remainingTickets;
	}

	public void setRemainingTickets(int remainingTickets) {
		this.remainingTickets = remainingTickets;
	}



	public int getRaffleId() {
		return raffleId;
	}

	public void setRaffleId(int raffleId) {
		this.raffleId = raffleId;
	}


}
