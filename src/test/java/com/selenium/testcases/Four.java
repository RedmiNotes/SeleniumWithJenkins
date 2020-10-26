package com.selenium.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.common.One;
import com.selenium.pages.Two;
import com.selenium.projectspecify.Three;

public class Four extends Three {

	@BeforeClass
	public void b_class() {
		startbrowser("ch");
	}

	@Test
	public void tc_01() {
		new Two(driver).get_title();
	}
}