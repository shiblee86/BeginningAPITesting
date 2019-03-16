package com.apisetup;

import com.objectrepo.ObjectRepo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseAPIPage {

	public void loadAPIUrl() {

		RestAssured.baseURI = ObjectRepo.loadApiURI;
	}

	public JsonPath getJsonPath(Response response) {
		return response.jsonPath();
	}

	public void getExistingPlantetsUri() {
		RestAssured.baseURI = ObjectRepo.exsistingPlanetsURI;
	}

	public void getNonExistingPlanetsUri() {
		RestAssured.baseURI = ObjectRepo.nonExsistingPlanetsURI;
	}

}
