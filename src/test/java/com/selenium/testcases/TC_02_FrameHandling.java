package com.selenium.testcases;

import java.util.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import com.selenium.common.SeleniumCommon;
import com.selenium.pages.FrameHandling;
import com.selenium.projectspecify.ProjectSpecify;

public class TC_02_FrameHandling extends ProjectSpecify {

	@BeforeClass
	public void startpage() {
		desc = "<h4><font color='blue'>TC_02 Frame Handling</font></h4>";
		startbrowser("chrome","frames");
		n = new Random().nextInt(5);
	}

	@Test(dataProvider = "datas")
	public void framehandling(Map<String,String> map) {
		FrameHandling fh = PageFactory.initElements(driver, FrameHandling.class);
		fh.frame_size();
		fh.enter_name(map.get("Name"));
	}
	@AfterSuite
	public void closebrowser() {
		driver.close();
		driver.quit();
	}
}