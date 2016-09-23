package gamesys.hr.raffle.cucumber.stepdef;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.apache.commons.lang3.RandomStringUtils;
import util.ApiUtils;
import util.General;
import util.RequestBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

public class StepDefs {

	private static RequestBuilder requestBuilder = new RequestBuilder();
	private static ApiUtils apiUtils = new ApiUtils();

	@Given("^I have requested a raffle with \"([^\"]*)\" number of tickets$")
	public void I_have_requested_a_raffle_with(String numberOfTickets) throws IOException, URISyntaxException {

		String raffleRequest = requestBuilder.buildRaffleRequest(numberOfTickets);
		apiUtils.sendRaffleRequest(raffleRequest);
		Assert.assertNotNull(apiUtils.getMessageContext().getRaffleId());
		Assert.assertNotNull(apiUtils.getMessageContext().getCode());
		Assert.assertNotNull(apiUtils.getMessageContext().getRaffleName());
		Assert.assertNotNull(apiUtils.getMessageContext().getRemainingTickets());
	}

	@Given("^I have requested to register a player with name \"([^\"]*)\" and email \"([^\"]*)\" and dob \"([^\"]*)\"$")
	public void I_have_registered_a_player_with_name_and_email_and_dob(String name, String email, String dob) throws IOException {

		String playerRegistrationRequest  = requestBuilder.buildPlayerRegistrationRequest(name, email, dob);
		apiUtils.sendPlayerRegistrationRequest(playerRegistrationRequest);

	}

	@Then("^player is successfully registered$")
	public void player_is_successfully_registered()  {

		Assert.assertNotNull(apiUtils.getMessageContext().getPlayerName());
		Assert.assertNotNull(apiUtils.getMessageContext().getPlayerId());
		Assert.assertNotNull(apiUtils.getMessageContext().getEmail());
		Assert.assertNotNull(apiUtils.getMessageContext().getDob());
		Assert.assertNull(apiUtils.getMessageContext().getReason());
	}

	@Then("^I successfully request \"([^\"]*)\" tickets for player \"([^\"]*)\"$")
	public void I_successfully_request_tickets_for_player(int numberOfTickets, String playerName) throws IOException {
		int playerId = apiUtils.getMessageContext().getPlayers().get(playerName);
		int raffleId = apiUtils.getMessageContext().getRaffleId();
		String ticketRequest = requestBuilder.buildTicketRequest(playerId, raffleId);
		for (int i=1; i<=numberOfTickets; i++) {
			apiUtils.sendTicketRequest(ticketRequest);
			Assert.assertNotNull(apiUtils.getMessageContext().getTicketId());
			Assert.assertNull(apiUtils.getMessageContext().getReason());
		}
	}

	@Then("^successfully request the details for \"([^\"]*)\" with email \"([^\"]*)\" and dob \"([^\"]*)\"$")
	public void successfully_request_the_details_for_with_email_and_dob(String playerName, String email, String dob) throws IOException {
		String playerId = String.valueOf(apiUtils.getMessageContext().getPlayers().get(playerName));
		apiUtils.sendPlayerDetailsRequest(playerId);
        Assert.assertEquals(playerName, apiUtils.getMessageContext().getNamePlayerDetails());
		Assert.assertEquals(email,apiUtils.getMessageContext().getEmailPlayerDetails());
		Assert.assertEquals(dob,apiUtils.getMessageContext().getDobPlayerDetails());

	}

	@Then("^I get error message \"([^\"]*)\"$")
	public void player_is_not_registered_with_error_message(String errorMessage)  {

		Assert.assertEquals(errorMessage,apiUtils.getMessageContext().getReason());
	}

	@Then("^I request \"([^\"]*)\" tickets for non existing player$")
	public void I_request_tickets_for_player(int numberOfTickets) throws IOException {
		int playerId = Integer.parseInt(RandomStringUtils.randomNumeric(4));
		int raffleId = apiUtils.getMessageContext().getRaffleId();
		String ticketRequest = requestBuilder.buildTicketRequest(playerId, raffleId);
		for (int i=1; i<=numberOfTickets; i++) {
			apiUtils.sendTicketRequest(ticketRequest);
		}

	}

	@When("^I request \"([^\"]*)\" tickets for non existing raffle for user \"([^\"]*)\"$")
	public void I_request_tickets_for_non_existing_raffle_for_user(int numberOfTickets, String playerName) throws IOException {

		int playerId = apiUtils.getMessageContext().getPlayers().get(playerName);
		int raffleId = Integer.parseInt(RandomStringUtils.randomNumeric(4));
		String ticketRequest = requestBuilder.buildTicketRequest(playerId, raffleId);
		for (int i=1; i<=numberOfTickets; i++) {
			apiUtils.sendTicketRequest(ticketRequest);
		}
	}


	@Then("^I request \"([^\"]*)\" number of tickets for player \"([^\"]*)\" with correct error message \"([^\"]*)\" for the non available tickets$")
	public void I_request_number_of_tickets_for_player_with_correct_error_message_for_the_non_available_tickets(int numberOfTickets, String playerName, String errorMessage) throws IOException {
		int playerId = apiUtils.getMessageContext().getPlayers().get(playerName);
		int raffleId = apiUtils.getMessageContext().getRaffleId();
		String ticketRequest = requestBuilder.buildTicketRequest(playerId, raffleId);
		for (int i=1; i<=numberOfTickets; i++) {
			apiUtils.sendTicketRequest(ticketRequest);
			if (i <= apiUtils.getMessageContext().getNumberOfTickets()) {
				Assert.assertNull(apiUtils.getMessageContext().getReason());
			}
			else  {
				Assert.assertEquals(errorMessage,apiUtils.getMessageContext().getReason());
			}
		}
	}

	@Given("^I have requested to register an underaged player with name \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void I_have_requested_to_register_an_underaged_player_with_name_and_email(String playerName, String email) throws IOException {

		String dob  = General.getUnderAgedPlayerDate();
		String playerRegistrationRequest  = requestBuilder.buildPlayerRegistrationRequest(playerName, email, dob);
		apiUtils.sendPlayerRegistrationRequest(playerRegistrationRequest);
	}

	@Given("^I request details for a non existing player with player id \"([^\"]*)\"$")
	public void I_request_details_for_a_non_existing_player_with_player_id(String playerId) throws IOException {

		System.out.println("player id from file: " + playerId);
		apiUtils.sendPlayerDetailsRequest(playerId);
	}

	@Then("^I get error code \"([^\"]*)\"$")
	public void I_get_error_code(int errorCode)  {
		org.junit.Assert.assertEquals(errorCode,apiUtils.getMessageContext().getErrorCode());

	}
}
