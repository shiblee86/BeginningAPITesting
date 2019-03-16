package com.objectrepo;

public class ObjectRepo {
	
	public static final String userDir;
	public static final String xmlFilePath;
	public static final String extentHtmlFile;
	public static final String loadApiURI;
	public static final String exsistingPlanetsURI;
	public static final String nonExsistingPlanetsURI;
	
	static {
		userDir = "user.Dir";
		xmlFilePath = "/extentConfig.xml";
		extentHtmlFile = "extentsReport.html";
		loadApiURI = "http://swapi.co/api/planets";
		exsistingPlanetsURI = "http://swapi.co/api/planets/11";
		nonExsistingPlanetsURI = "http://swapi.co/api/planets/11x";
	}
	
}
