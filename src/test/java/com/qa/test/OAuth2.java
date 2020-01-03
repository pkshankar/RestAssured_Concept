package com.qa.test;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2 {
	
	@Test
	public void handleOAuth2() {
		
		RestAssured.baseURI="http://coop.apps.symfonycasts.com";
		RequestSpecification request = RestAssured.given();
		request.auth().oauth2("26fe9117024bc02db2da40948d38f46adf81805b");
		Response response = request.post("/api/469/eggs-count");
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
	}

}
