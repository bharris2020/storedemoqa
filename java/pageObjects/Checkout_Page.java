package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Checkout_Page {
	
	private static WebElement element = null;
	
	//driver.get("http://store.demoqa.com/products-page/checkout");
	
	public static WebElement continueLink(WebDriver driver) {
		element = driver.findElement(By.linkText("Continue"));
		return element;
	}
	
	public static WebElement subTotalParent(WebDriver driver) {
		element = driver.findElement(By.className("yourtotal"));
		return element;
	}
	
	public static WebElement subTotalAmount(WebDriver driver, WebElement subTotalParent) {
		element = subTotalParent.findElement(By.className("pricedisplay"));
		return element;
		
	}
	
	public static WebElement iphonePriceParent(WebDriver driver) {
		element = driver.findElement(By.className("yourtotal"));
		return element;
	}
	
	public static WebElement iphonePriceAmount(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[size=\"46 x 15\"]"));
		return element;
		
	}
	
	public static WebElement quantity(WebDriver driver) {
		element = driver.findElement(By.name("quantity"));
		return element;
	}
	
	public static WebElement updateQuantity(WebDriver driver) {
		element = driver.findElement(By.name("submit"));
		return element;
	}
	
	public static WebElement countryDropdown(WebDriver driver) {
		element = driver.findElement(By.id("current_country"));
		return element;
	}
	
	//VALUE FOR UNITED STATES IN DROPDOWN GOES HERE...
	//WebElement country = driver.findElement(By.cssSelector("[value=\"United States\"]"));
	public static WebElement unitedStates(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[value=\"US\"]"));
		return element;
	}
	
	public static WebElement shippingCostState(WebDriver driver) {
		element = driver.findElement(By.name("collected_data[15]"));
		return element;
	}
	
	public static WebElement calculateButton(WebDriver driver) {
		element = driver.findElement(By.name("wpsc_submit_zipcode"));
		return element;
	}
	
	public static WebElement billingEmailAddress(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_9"));
		return element;
	}
	
	public static WebElement billingFirstName(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_2"));
		return element;
	}
	
	public static WebElement shippingFirstName(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_11"));
		return element;
	}
	
	public static WebElement billingLastName(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_3"));
		return element;
	}
	
	public static WebElement shippingLastName(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_12"));
		return element;
	}
	
	public static WebElement billingAddress(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_4"));
		return element;
	}
	
	public static WebElement shippingAddress(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_13"));
		return element;
	}
	
	public static WebElement billingCity(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_5"));
		return element;
	}
	
	public static WebElement shippingCity(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_14"));
		return element;
	}
	
	public static WebElement billingState(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_6"));
		return element;
	}
	
	public static WebElement shippingState(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_15"));
		return element;
	}
	
	public static WebElement billingCountry(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_7"));
		return element;
	}
	
	public static WebElement shippingCountry(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_16"));
		return element;
	}
	
	public static WebElement billingPostalCode(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_8"));
		return element;
	}
	
	public static WebElement shippingPostalCode(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_17"));
		return element;
	}
	
	public static WebElement phoneNumber(WebDriver driver) {
		element = driver.findElement(By.id("wpsc_checkout_form_18"));
		return element;
	}
	
	public static WebElement totalCost(WebDriver driver) {
		element = driver.findElement(By.id("checkout_total"));
		return element;
	}
	
	public static WebElement sameAsBilling(WebDriver driver) {
		element = driver.findElement(By.id("shippingSameBilling"));
		return element;
	}
	
	public static WebElement purchaseButton(WebDriver driver) {
		element = driver.findElement(By.cssSelector("[value=\"Purchase\"]"));
		return element;
	}
	
	public static WebElement shippingCostParent(WebDriver driver) {
		element = driver.findElement(By.className("wpsc_checkout_forms"));
		return element;
	}
	
	public static WebElement shippingCost(WebDriver driver, WebElement shippingCostParent) {
		element = shippingCostParent.findElement(By.className("pricedisplay"));
		return element;
	}
	
	 //String total = Checkout_Page.totalCost(driver).getText();
	 //Double totalCost = Double.parseDouble(total.replaceAll("[^\\d.]", ""));
	public static Double getDouble(WebDriver driver, WebElement element) {
		String a = element.getText();
		Double b = Double.parseDouble(a.replaceAll("[^\\d.]", ""));
		return b;
	}
	
	public static boolean verifySubtotal(Double quantity, Double price, Double subtotal) {
		if (subtotal!=quantity*price) {
			return false;
		}
		else {
			return true;
		}
			
			
	}
	
	public static void verifySubtotalAssertion(Double quantity, Double price, Double subtotal) {
		Assert.assertEquals(subtotal, price*quantity);
	}
	
	public static boolean verifyTotal(Double shipping, Double itemCost, Double total) {
		if (total != shipping+itemCost) {
			return false;
		}
		else {
		return true;
		}
	}
	
	public static void verifyTotalAssertion(Double shipping, Double itemCost, Double total) {
		Assert.assertEquals(total, shipping+itemCost);
	}
	
	//String price = Checkout_Page.subTotalAmount(driver, Checkout_Page.subTotalParent(driver)).getText();
	//Double phonePrice = Double.parseDouble(price.replaceAll("[^\\d.]", ""));
		
	public static Double phonePrice(WebElement subTotalAmount) {
		String price = subTotalAmount.getText();
		Double phonePrice = Double.parseDouble(price.replaceAll("[^\\d.]", ""));
		return phonePrice;
	}

}
