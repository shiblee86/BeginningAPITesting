package com.testcases;

import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apisetup.BaseAPIPage;

import io.restassured.response.Response;

public class StatusCode {
	
	@Test
	public void getStatusCode() {
	
		BaseAPIPage base = new BaseAPIPage();
		
		base.loadAPIUrl();
		Response response = get();
		
		System.out.println("Status Code :: " + response.getStatusCode());
		
		Assert.assertEquals(get(), 200);
	}

}
