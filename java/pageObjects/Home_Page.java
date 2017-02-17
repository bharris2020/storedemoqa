package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	
	private static WebElement element = null;
	
	public static WebElement productCategory_Link(WebDriver driver) {
		element = driver.findElement(By.id("menu-item-33"));
		return element;
	}
	
	public static WebElement iPhoneCategory_Link(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#menu-item-37 > a"));
		return element;
	}

}
