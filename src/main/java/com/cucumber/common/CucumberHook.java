package com.cucumber.common;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHook extends CucumberCommon {
	
	public void startreport(String s2) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss a");
		String s1 = sdf.format(d)+".html";
		report = new ExtentReports("./htmlreport/"+s1,true,DisplayOrder.NEWEST_FIRST);
		report.addSystemInfo("Host Name", "Admin");
		report.addSystemInfo("User Name", "Admin");
		report.addSystemInfo("Environment", "QA");
		test = report.startTest(s2,"Scenario_1");
	}
	@Before(order = 1)
	public void start_browser(Scenario feature) {
		startreport(feature.getName().replaceAll(" ", "_"));
		startbrowser();
	}
	@After(order = 1)
	public void endreport() {
		report.endTest(test);
		report.flush();
		driver.close();
		driver.quit();
	}
}