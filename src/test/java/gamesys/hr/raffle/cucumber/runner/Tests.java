package gamesys.hr.raffle.cucumber.runner;

import model.CustomHttpResponse;
import org.junit.Test;
import util.HttpRequest;

import java.io.IOException;

/**
 * Created by c1766077 on 12/07/16.
 */
public class Tests {

	@Test
	public void testZplDpd() throws IOException {
		String url = "https://api-test.marksandspencer.com/v1/storedelivery/shipment/label/shipmentId/134844663";
		String authKeys = "MSAuth apikey=INM7TVysPGBwNGryjGMrLkwAyAKkZKho, secretkey=wPbILptOYoD9AcoD";
		String shipmentSession = "MTAuMjYuMy42OXwtODQ4ODA2NzUz";
		System.out.println("url: "+ url);

		CustomHttpResponse response  = HttpRequest.sendRequest1(url, "GET","application/json", null, true, authKeys, shipmentSession);
		System.out.println("response is: "+ response.getResponseBody());

	}

}
