package com.selenium.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,dryRun = false,features = {"./FeatureFile/Textbox.feature"},
glue = {"com.cucumber.common","com.selenium.cucumber.scenario"},
plugin = {"pretty","html:CucumberReport/extent-report_one","json:CucumberReport/report_one.json"})
public class Edit_Runner extends AbstractTestNGCucumberTests {

}