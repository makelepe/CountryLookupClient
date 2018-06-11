package com.country.lookup.client.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestCallerHelper {
	
	public String getCountry (String ipAddress) {

		  try {
			URL url = new URL("http://localhost:8080/lookup/country/?ipAddress="+ipAddress);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			// if response not 200 -- server failed!
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			// read output from server
			String output;
			while ((output = br.readLine()) != null) {
				return output;
			}
			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		  return null;
	}

}
