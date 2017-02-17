package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Iphone_Page {
	
	private static WebElement element = null;
	
	//driver.get("http://store.demoqa.com/products-page/product-category/iphones");
	
	public static WebElement productCategory_Link(WebDriver driver) {
		element = driver.findElement(By.linkText("Go to Checkout"));
		return element;
	}
	
	public static WebElement iphone4ParentClass(WebDriver driver) {
		element = driver.findElement(By.name("product_96"));
		return element;
	}
	
	public static WebElement iphone4Price(WebDriver driver, WebElement iphone4ParentClass) {
		element = iphone4ParentClass.findElement(By.className("wpsc_product_price"));
		return element;
	}
	
	public static WebElement iphone4CurrentPrice(WebDriver driver, WebElement iphone4Price) {
		element = iphone4Price.findElement(By.className("currentprice pricedisplay product_price_96"));
		return element;
	}
	
	public static WebElement iphone4AddToCartButton(WebDriver driver, WebElement iphone4ParentClass) {
		element = iphone4ParentClass.findElement(By.cssSelector("[value=\"Add To Cart\"]"));
		return element;
	}
	
	public static WebElement goToCheckout(WebDriver driver) {
		element = driver.findElement(By.linkText("Go to Checkout"));
		return element;
	}
	
	public static WebElement youSaveParent(WebDriver driver, WebElement iphone32GBParentClass) {
		element = iphone32GBParentClass.findElement(By.className("wpsc_product_price"));
		return element;
	}
	
	public static WebElement iphone32GBParentClass(WebDriver driver) {
		element = driver.findElement(By.name("product_98"));
		return element;
	}
	
	public static void youSaveAssertion(Double original, Double discounted, Double discount) {
		Assert.assertEquals(discounted, original-discount);
	}

}
