package com.qa.test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserDeserialization {

	@SuppressWarnings("unchecked")
	@Test
	public void createUser() {

		RestAssured.baseURI = "http://restapi.demoqa.com";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("FirstName", "Swanty");
		jsonObject.put("LastName", "Pole");
		jsonObject.put("UserName", "swanpol");
		jsonObject.put("Password", "swan01");
		jsonObject.put("Email", "swanpol@zmail.com");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jsonObject.toJSONString());
		Response response = httpRequest.request(Method.POST, "/customer/register");

		// DESERIALIZATION

		CreateUserDeserializationJavaObject createUserDeserializationJavaObject = response
				.as(CreateUserDeserializationJavaObject.class);

		System.out.println(createUserDeserializationJavaObject.SuccessCode);
		System.out.println(createUserDeserializationJavaObject.Message);

	}

}
