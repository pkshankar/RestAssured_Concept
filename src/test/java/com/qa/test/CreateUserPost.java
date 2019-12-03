package com.qa.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserPost {

	
	@SuppressWarnings("unchecked")
	@Test
	public void createUser() {
		
		
		RestAssured.baseURI="http://restapi.demoqa.com";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("FirstName", "Som");
		jsonObject.put("LastName", "Vaid");
		jsonObject.put("UserName", "somvaid001");
		jsonObject.put("Password", "som001");
		jsonObject.put("Email", "somvaid@zmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonObject.toJSONString());
		Response response = httpRequest.request(Method.POST, "/customer/register");
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeaders());

	}
}
