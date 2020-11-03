package com.selenium.cucumber.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,dryRun = false,
features = {"./FeatureFile/LetitCode.feature"},
glue = {"com.cucumber.common","com.selenium.cucumber.scenario"})
public class LetitCode_runner {

}
