package com.selenium.testcases;

import java.util.Random;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.selenium.common.One;

public class Slider_Example extends One {
	
	@Test
	public void slider_01() {
		String s1 = System.getProperty("user.dir")+"\\HTML_FILE\\Slider.html";
		driver.get(s1);
		wait(2);
		WebElement slider_1 = driver.findElement(By.xpath("(//input[@type='range'])[1]"));
		action.clickAndHold(slider_1).moveByOffset(0, new  Random().nextInt(100)).build().perform();
		wait(3);
	}

}
