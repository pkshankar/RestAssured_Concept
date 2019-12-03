package com.qa.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetFormulaOne {

	@Test
	public void getFormulaOneDetails() {

		RestAssured.baseURI = "http://ergast.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/api/f1/1966/circuits.json");
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		String jsonResponse = response.getBody().asString();
		JsonPath jsonPath = response.jsonPath();
		
		Headers headers = response.getHeaders();
		//System.out.println(" STATUS CODE: " + statusCode);
		//System.out.println(" STATUS LINE: " + statusLine);
		//System.out.println(" JSON RESPONSE: " + jsonResponse);
		System.out.println(" VALUE: " + jsonPath.getJsonObject("MRData.CircuitTable.Circuits.Location.country"));
		//System.out.println("ALL HEADERS: " + headers);

	}

}
