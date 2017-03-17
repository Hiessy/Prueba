package com.web.application.service.google.connectors;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.application.model.google.dto.GoogleResponse;

public class GoogleConnector {
	
	private final static String GOOGLE_MAP_API_BASEURL = "https://maps.googleapis.com/maps/api/";
	private final static String key = "&key=AIzaSyBOCG70ge8cxiuJGZZynAr6x3txjsiCbok";
	private static Logger LOGGER = LoggerFactory.getLogger(GoogleConnector.class);
	
	
	private static String createGoogleRequest(String addressNumber, String streetName, String cityName, String provinceName, String countryName) {
		String baseUrl = "geocode/json?";
		String address = "address=" + addressNumber + "+" + streetName + ",+" + cityName + ",+" + provinceName + ",+" + countryName;
		String requestUrl = GOOGLE_MAP_API_BASEURL + baseUrl + address + key;
		return (requestUrl);
	}

	public static GoogleResponse getGoogleResponse(int addressNumber, String streetName, String cityName, String provinceName, String countryName) {

		ObjectMapper mapper = new ObjectMapper();
		String requestURL = createGoogleRequest(String.valueOf(addressNumber), streetName, cityName, provinceName, countryName).replaceAll(" ", "%20");
		LOGGER.info(requestURL);
		GoogleResponse serverResponse = null;

		try {
			
			//HttpURLConnection connection = (HttpURLConnection) new URL(requestURL).openConnection();
			
			HttpURLConnection connection = setProxy(requestURL);
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			connection.setRequestMethod("GET");
			InputStream is = connection.getInputStream();
			serverResponse = mapper.readValue(is, GoogleResponse.class);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverResponse;
	}
	
	private static HttpURLConnection setProxy(String urlString) throws MalformedURLException, IOException{		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("isaproxy", 80));
		HttpURLConnection conn = (HttpURLConnection) new URL(urlString).openConnection(proxy);
		   Authenticator authenticator = new Authenticator() {

		        public PasswordAuthentication getPasswordAuthentication() {
		            return (new PasswordAuthentication("u584110",
		                    "Atos2004!".toCharArray()));
		        }
		    };
		    Authenticator.setDefault(authenticator);
		    
		    return conn;
	}
}
