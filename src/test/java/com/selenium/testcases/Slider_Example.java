package com.selenium.testcases;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.selenium.common.One;

public class Slider_Example extends One {
	
	public static int random() {
		return new Random().nextInt(100);
	}
	
	@Test
	public void slider_01() {
		String s1 = System.getProperty("user.dir")+"\\HTML_FILE\\Slider.html";
		driver.get(s1);
		wait(2);
		WebElement slider_1 = driver.findElement(By.xpath("(//input[@type='range'])[1]"));
		action.clickAndHold(slider_1).moveByOffset(0, random()).build().perform();
		wait(3);
		WebElement slider_2 = driver.findElement(By.xpath("(//input[@type='range'])[2]"));
		action.clickAndHold(slider_2).moveByOffset(0, random()).build().perform();
		wait(3);
		WebElement slider_3 = driver.findElement(By.xpath("(//input[@type='range'])[3]"));
		action.clickAndHold(slider_3).moveByOffset(0, random()).build().perform();
		wait(3);
		
		WebElement value = driver.findElement(By.xpath("//span[@id='demo']"));
		String s2 = value.getText();
		System.out.println("The Value is : " + s2);
	}

}
