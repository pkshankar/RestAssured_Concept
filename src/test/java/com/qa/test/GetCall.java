package com.qa.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCall {
	
	@Test
	public void getWeatherInfo() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/utilities/weather/city/delhi");
		System.out.println("RESPONSE BODY : " + response.getBody().asString());
		System.out.println("RESPONSE STATUS CODE : " + response.getStatusCode());
		System.out.println(response.getStatusLine());
		JsonPath jPath = response.jsonPath();
		System.out.println(jPath.get("City"));
		Headers headers = response.getHeaders();
		System.out.println(headers);
		System.out.println(response.getHeader("Content-Type"));
		
	}

}
