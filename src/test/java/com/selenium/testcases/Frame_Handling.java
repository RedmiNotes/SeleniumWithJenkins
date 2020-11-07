package com.selenium.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.selenium.common.One;

public class Frame_Handling extends One {
	
	@Test
	public void frames_handling() {
		driver.get("https://letcode.in/frame");
		wait(3);
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frames.get(0));
		wait(2);
		driver.findElement(By.xpath("//input[contains(@placeholder,'name')]")).sendKeys("Dinesh");
		wait(3);
		driver.findElement(By.xpath("//input[contains(@placeholder,'email')]")).sendKeys("dinesh123@mail.com");
		wait(3);
		driver.switchTo().defaultContent();
		wait(3);
	}
}