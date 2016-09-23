package util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import model.PlayerBuilder;
import model.RaffleBuilder;
import model.TicketBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;


public class RequestBuilder {


	private static RandomDataGen randomDataGen = new RandomDataGen();
	private static Gson gson = new GsonBuilder().create();

	public String buildRaffleRequest(String numberOfTickets) throws FileNotFoundException, URISyntaxException {

		randomDataGen.generateRandomData();
		JsonElement jsonElement = new JsonParser().parse(new FileReader(new File("src/test/resources/raffle.json")));
		RaffleBuilder raffleRequest = gson.fromJson(String.valueOf(jsonElement),RaffleBuilder.class);
		raffleRequest.setName(randomDataGen.getRaffleName());
		raffleRequest.setNumberOfTickets(Integer.valueOf(numberOfTickets));
		String request = gson.toJson(raffleRequest);

		return request;
	}

	public String buildPlayerRegistrationRequest (String name, String email, String dob) throws FileNotFoundException {
		JsonElement jsonElement = new JsonParser().parse(new FileReader(new File("src/test/resources/player.json")));
		PlayerBuilder playerRegistrationRequest =  gson.fromJson(String.valueOf(jsonElement),PlayerBuilder.class);
		playerRegistrationRequest.setName(name);
		playerRegistrationRequest.setEmail(email);
		playerRegistrationRequest.setDob(dob);
		String request = gson.toJson(playerRegistrationRequest);

		return request;
	}

	public String buildTicketRequest (int playerId, int raffleId) throws FileNotFoundException {
		JsonElement jsonElement = new JsonParser().parse(new FileReader(new File("src/test/resources/ticket.json")));
		TicketBuilder ticketBuilderRequest = gson.fromJson(String.valueOf(jsonElement),TicketBuilder.class);
		ticketBuilderRequest.setPlayerId(playerId);
		ticketBuilderRequest.setRaffleId(raffleId);
		String request = gson.toJson(ticketBuilderRequest);
		return request;
	}

}
