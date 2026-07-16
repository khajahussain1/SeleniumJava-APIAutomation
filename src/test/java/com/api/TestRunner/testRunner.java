package com.api.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = { "src/test/resources/features/" }, glue = {
		"com.api.Step_Defination" }, plugin = { "pretty",
		"html:target/Cucumber_HTMLReports/Reports.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				dryRun = false, tags = ("@Smoke_test"))

public class testRunner extends AbstractTestNGCucumberTests {
	public String testcasename;


	@BeforeClass
	public void beforeclass() {
		testcasename = this.getClass().getSimpleName();
		System.out.println("************** Start " + testcasename + " Test ****************");
	}

	@AfterClass
	public void testDownClass() {
		System.out.println("************** End " + testcasename + " Test ****************");

	}

}
