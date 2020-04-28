/**
 *
 */
package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * @author W252625
 *
 */
public class RestClient {

	//1. Get Method

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
		//http clients class
		////HTTPClients is a library
		// default clients opens up HTTP client connection
		//returns one closeable http client class objet
	//	CloseablehttpClients httpClient =HTTPCLients .create
	CloseableHttpClient httpClient =	HttpClients.createDefault();
	// get class create connection with particular URL >
	HttpGet httpget = new HttpGet(url);
	// return a  closeible http response
	CloseableHttpResponse  closehttpresponse = httpClient.execute(httpget);// hit the GET URL
	//grabs the status code (example 200, 400 ,404

	// return the class name object
	return closehttpresponse;

	//Status code:


}
}
