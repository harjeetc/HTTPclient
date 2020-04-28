/**
 *
 */
package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

/**
 * @author W252625
 *
 */
public class GetAPITest extends TestBase {

	TestBase testbase;
	String serviceurl;
	String apiURL;
	RestClient restClient;
	String url;
	CloseableHttpResponse  closehttpresponse;

	@BeforeTest
	public void getURL() throws ClientProtocolException, IOException{
		testbase = new TestBase();
		serviceurl =	prop.getProperty("URL");
		apiURL = 	prop.getProperty("serviceURL");
		url = serviceurl + apiURL;



	}

	@Test
	public void getTest() throws ClientProtocolException, IOException{
	restClient = new RestClient();
	closehttpresponse =	restClient.get(url);


		//Status code:
	int statuscode =	closehttpresponse.getStatusLine().getStatusCode();
	System.out.println("status code->>>>" + statuscode);


	Assert.assertEquals(statuscode, Response_Status_200, "Status code is not 200");



	// grab the response string
	//entity utils class - pass entity method,  grab in format utf-8
	//returning a String
		String responseString =	EntityUtils.toString(closehttpresponse.getEntity(), "UTF-8");
		//store response string into json object
//		String source;
		// remove double quote json object will return with brackets.

		// JSON String :
		JSONObject responsejsonobject = new JSONObject(responseString);
	System.out.println("response of the json code ---->>>>" + responsejsonobject );

	// grab all headers from the GET response from closeable http response  and return in object Header  in form of a ARRAY string

			// All Headers :
				Header[] headerArray =	closehttpresponse.getAllHeaders();
				// ]create Hashmap and store key value pair [key,value]
				HashMap<String,String> allHeaders = new HashMap<String,String>();
				// loop through all the headers and store in a variable called called header
				for (Header header : headerArray) {
					allHeaders.put(header.getName(), header.getValue());

				}

				//
				System.out.println("all the headers---->>>>>>" + allHeaders);


		}


	}


