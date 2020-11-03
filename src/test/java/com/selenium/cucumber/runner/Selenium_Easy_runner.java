package com.selenium.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,dryRun = false,strict = true,snippets = SnippetType.CAMELCASE,
features = {"./FeatureFile/SeleniumEasy.feature"},
glue = {"com.cucumber.common","com.selenium.cucumber.scenario"})
public class Selenium_Easy_runner extends AbstractTestNGCucumberTests {

}