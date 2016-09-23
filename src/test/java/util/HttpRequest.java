package util;

import model.CustomHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Security;


public class HttpRequest {

	/**
	 * Method to send http requests
	 * @param url
	 * @param type
	 * @param contentType
	 * @param postBody
	 * @param authentication
	 * @param authKeys
	 * @return
	 * @throws IOException
	 */
	public static CustomHttpResponse sendRequest(
			String url, String type, String contentType, String postBody, boolean authentication, String authKeys)
			throws IOException {

		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		URL object = new URL(url);
		// open conenction
		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		// set headers
		con.setRequestMethod(type);

		if (authentication) {
			con.setRequestProperty("Authorization", authKeys);
		}

		// write http post body
		if ((type.equalsIgnoreCase("POST")) && (postBody != null)) {
			con.setRequestProperty("Content-Type", contentType);
			con.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
			writer.write(postBody);
			writer.close();
		}
		// store status code and response body in CustomHttpResponse object and
		// return response
		CustomHttpResponse response = new CustomHttpResponse();
		StringBuffer responseBuffer = new StringBuffer();
		String inputLine;
		BufferedReader in;

		if (con.getResponseCode() == 200 || con.getResponseCode() == 201) {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		} else {
			in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		while ((inputLine = in.readLine()) != null) {
			responseBuffer.append(inputLine);
		}

		response.setResponseBody(responseBuffer.toString());
		response.setResponseCode(con.getResponseCode());
		in.close();

		return response;
	}

	public static CustomHttpResponse sendRequest1(
			String url, String type, String contentType, String postBody, boolean authentication, String authKeys, String shipmentSession)
			throws IOException {

		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		URL object = new URL(url);
		// open conenction
		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		// set headers
		con.setRequestMethod(type);

		if (shipmentSession != null) {
			con.setRequestProperty("ShipmentSession",shipmentSession);
		}
		if (authentication) {
			con.setRequestProperty("Authorization", authKeys);
		}
		con.setRequestProperty("Content-Type", contentType);
		// write http post body
		if ((type.equalsIgnoreCase("POST")) && (postBody != null)) {
			con.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
			writer.write(postBody);
			writer.close();
		}
		// store status code and response body in CustomHttpResponse object and
		// return response
		CustomHttpResponse response = new CustomHttpResponse();
		StringBuffer responseBuffer = new StringBuffer();
		String inputLine;
		BufferedReader in;

		if (con.getResponseCode() == 200 || con.getResponseCode() == 201) {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		} else {
			in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		while ((inputLine = in.readLine()) != null) {
			responseBuffer.append(inputLine);
		}

		response.setResponseBody(responseBuffer.toString());
		response.setResponseCode(con.getResponseCode());
		in.close();

		return response;
	}

}
