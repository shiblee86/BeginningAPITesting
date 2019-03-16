package com.extentreport;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.objectrepo.ObjectRepo;

public class BaseExtentReport {

	public ExtentHtmlReporter report;

	public ExtentReports extent;

	public ExtentTest test;

	@BeforeTest
	public void runBeforeSuit() {
		report = new ExtentHtmlReporter(new File(System.getProperty(ObjectRepo.userDir + ObjectRepo.extentHtmlFile)));

		report.loadXMLConfig(ObjectRepo.userDir + ObjectRepo.xmlFilePath);

		extent = new ExtentReports();
		extent.setSystemInfo("Testing enviornment", "API Testing");

	}

	@BeforeMethod
	public void runBeforeMethod(Method method) {

		String testName = method.getName();
		test = extent.createTest(testName);
	}

	@AfterMethod
	public void runAfterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "The test status:: " + result.getStatus() + ":: Test Failed!");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "The test status:: " + result.getStatus() + ":: Test Passed!");
		} else {
			test.log(Status.SKIP, "The test status:: " + result.getStatus() + ":: Test Skipped! ");
		}
	}
	@AfterTest
	public void runAfterTest() {
		extent.flush();
	}

}
