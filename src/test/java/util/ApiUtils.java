package util;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import model.*;
import model.Error;

import java.io.IOException;
import java.util.HashMap;

public class ApiUtils {

	private static Gson gson = new GsonBuilder().create();
	MessageContext messageContext = new MessageContext();

	public CustomHttpResponse sendRaffleRequest (String raffleRequest) throws IOException {
		CustomHttpResponse response  = HttpRequest.sendRequest("http://localhost:8080/raffles", "POST", "application/json",raffleRequest,false,null );

		if (response.getResponseCode() == 200) {
			RaffleBuilder raffleBuilder = gson.fromJson(response.getResponseBody(), RaffleBuilder.class);
			messageContext.setRaffleId(raffleBuilder.getId());
			messageContext.setRemainingTickets(raffleBuilder.getRemainingTickets());
			messageContext.setRaffleName(raffleBuilder.getName());
			messageContext.setCode(raffleBuilder.getCode());
			messageContext.setNumberOfTickets(raffleBuilder.getNumberOfTickets());
		}

		return response;
	}


	public CustomHttpResponse sendPlayerRegistrationRequest(String playerRegistrationRequest) throws IOException {
		CustomHttpResponse response  = HttpRequest.sendRequest("http://localhost:8080/players", "POST", "application/json",playerRegistrationRequest,false,null );
        if (response.getResponseCode() == 200) {
			PlayerBuilder playerBuilder = gson.fromJson(response.getResponseBody(), PlayerBuilder.class);
			messageContext.setPlayerName(playerBuilder.getName());
			messageContext.setPlayerId(playerBuilder.getId());
			messageContext.setEmail(playerBuilder.getEmail());
			messageContext.setDob(playerBuilder.getDob());
			HashMap<String, Integer> players = new HashMap<String, Integer>();
			players.put(playerBuilder.getName(), playerBuilder.getId());
			messageContext.setPlayers(players);
		}
		else {
			Error error  = gson.fromJson(response.getResponseBody(), Error.class);
			messageContext.setReason(error.getReason());
		}
		 return response;
	}

	public CustomHttpResponse sendTicketRequest(String ticketRequest) throws IOException {
		CustomHttpResponse response  = HttpRequest.sendRequest("http://localhost:8080/ticket-api/ticket-requests", "POST", "application/json",ticketRequest,false,null );
		if (response.getResponseCode() == 200) {
			TicketBuilder ticketBuilder = gson.fromJson(response.getResponseBody(), TicketBuilder.class);
			messageContext.setTicketId(ticketBuilder.getId());
			messageContext.setPlayerIdWithTicket(ticketBuilder.getPlayerId());
		}
		else {
			Error error  = gson.fromJson(response.getResponseBody(), Error.class);
			messageContext.setReason(error.getReason());
		}
		return response;
	}

	public CustomHttpResponse sendPlayerDetailsRequest(String playerId) throws IOException {
		String url = "http://localhost:8080/players/" + playerId;
		CustomHttpResponse response  = HttpRequest.sendRequest(url, "GET", "application/json",null,false,null );
		if (response.getResponseCode() == 200) {
     PlayerDetailsBuilder playerDetailsBuilder = gson.fromJson(response.getResponseBody(), PlayerDetailsBuilder.class);
			messageContext.setDobPlayerDetails(playerDetailsBuilder.getDob());
			messageContext.setEmailPlayerDetails(playerDetailsBuilder.getEmail());
			messageContext.setNamePlayerDetails(playerDetailsBuilder.getName());
		}
		messageContext.setErrorCode(response.getResponseCode());
		return response;
	}

	public MessageContext getMessageContext () {
		return messageContext;
	}
}
