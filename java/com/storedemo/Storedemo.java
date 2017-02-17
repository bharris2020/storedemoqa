package com.storedemo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import pageObjects.Checkout_Page;
import pageObjects.Home_Page;
import pageObjects.Iphone_Page;

/**
 * Hello world!
 *
 */
public class Storedemo 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
    	//WebDriver driver = openBrowser();
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("http://store.demoqa.com");
    	//WebElement productCategoryLink = driver.findElement(By.id("menu-item-33"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(Home_Page.productCategory_Link(driver)).build().perform();
    	//WebElement iphoneLink = driver.findElement(By.cssSelector("#menu-item-37 > a"));
    	Home_Page.iPhoneCategory_Link(driver).click();
    	//Home_Page.productCategory_Link(driver).click();
    	//Thread.sleep(3000);
    	//Home_Page.iPhoneCategory_Link(driver).click();
    	//actions.click().build().perform();
    	Thread.sleep(2000);
    	//driver.get("http://store.demoqa.com/products-page/product-category/iphones");
    	//WebElement iphone4ParentClass = null;
		//Iphone_Page.iphone4ParentClass(driver);
    	//Thread.sleep(6000);
    	//Iphone_Page.iphone4ParentClass(driver).click();
   	 	//String d = Iphone_Page.iphone4CurrentPrice(driver, Iphone_Page.iphone4Price(driver, Iphone_Page.iphone4ParentClass(driver))).getText();
   	 	//System.out.println(d);
    	Iphone_Page.iphone4AddToCartButton(driver, Iphone_Page.iphone4ParentClass(driver)).click();
    	Thread.sleep(2000);
    	Iphone_Page.goToCheckout(driver).click();
    	Thread.sleep(2000);
    	String price = Checkout_Page.subTotalAmount(driver, Checkout_Page.subTotalParent(driver)).getText();
    	Double phonePrice = Double.parseDouble(price.replaceAll("[^\\d.]", ""));
    	String quantity = Checkout_Page.quantity(driver).getAttribute("value");
    	 Double quantityActual = Double.parseDouble(quantity.replaceAll("[^\\d.]", ""));
    	 String subtotal = Checkout_Page.subTotalAmount(driver, Checkout_Page.subTotalParent(driver)).getText();
    	 Double subtotalActual = Double.parseDouble(subtotal.replaceAll("[^\\d.]", ""));
    	 //Checkout_Page.verifySubtotal(quantityActual, phonePrice, subtotalActual);
    	 Checkout_Page.verifySubtotalAssertion(quantityActual, phonePrice, subtotalActual);
    	//System.out.println(phonePrice);
    	Checkout_Page.quantity(driver).clear();
    	//Thread.sleep(1000);
    	Checkout_Page.quantity(driver).sendKeys("3");
    	//String d = Checkout_Page.iphonePriceAmount(driver).getText();
    	//System.out.println(d);
    	Checkout_Page.updateQuantity(driver).click();
    	Thread.sleep(2000);
    	//The lines below are responsible for isolating the values used to calculate subtotals and totals for verification equations...
    	 subtotal = Checkout_Page.subTotalAmount(driver, Checkout_Page.subTotalParent(driver)).getText();
    	 //System.out.println(subtotal);
    	 //The logic below removes the $ and converts the string to a double...
    	 subtotalActual = Double.parseDouble(subtotal.replaceAll("[^\\d.]", ""));
    	 //System.out.println(subtotalActual);
    	 //Thread.sleep(1000);
    	 quantity = Checkout_Page.quantity(driver).getAttribute("value");
    	 //System.out.println(quantity);
    	 quantityActual = Double.parseDouble(quantity.replaceAll("[^\\d.]", ""));
     	//The lines above^^^ are responsible for isolating the values used to calculate subtotals and totals for verification equations...
    	 //Checkout_Page.verifySubtotal(quantityActual, phonePrice, subtotalActual);
    	 Checkout_Page.verifySubtotalAssertion(quantityActual, phonePrice, subtotalActual);
    	 //Thread.sleep(1000);
    	 Checkout_Page.continueLink(driver).click();
    	 Thread.sleep(4000);
    	 Checkout_Page.countryDropdown(driver).click();
    	 Thread.sleep(1000);
    	 Checkout_Page.unitedStates(driver).click();
    	 Checkout_Page.shippingCostState(driver).sendKeys("Ga");
    	 Checkout_Page.calculateButton(driver).click();
    	 Thread.sleep(5000);
    	 Checkout_Page.billingEmailAddress(driver).sendKeys("bjizl2020@gmail.com");
    	 Checkout_Page.billingFirstName(driver).sendKeys("Basil");
    	 Checkout_Page.billingLastName(driver).sendKeys("Harris");
    	 Checkout_Page.billingAddress(driver).sendKeys("854 Beards Creek Church Rd.");
    	 Checkout_Page.billingCity(driver).sendKeys("Glennville");
    	 Checkout_Page.billingCountry(driver).click();
    	 Checkout_Page.billingCountry(driver).sendKeys("USA");
    	 Thread.sleep(2000);
    	 //Checkout_Page.unitedStates(driver).click();
    	 Checkout_Page.billingState(driver).sendKeys("Ga");
    	 Checkout_Page.billingPostalCode(driver).sendKeys("30427");
    	 Checkout_Page.phoneNumber(driver).sendKeys("912-237-1758");
    	 Checkout_Page.sameAsBilling(driver).click();
    	 Thread.sleep(2000);
    	 //String shipping = Checkout_Page.shippingCost(driver).getText();
    	 //System.out.println(shipping);
    	 String shipping = Checkout_Page.shippingCost(driver, Checkout_Page.shippingCostParent(driver)).getText();
    	 //System.out.println(shipping);
    	 Double shippingCost = Double.parseDouble(shipping.replaceAll("[^\\d.]", ""));
    	 String total = Checkout_Page.totalCost(driver).getText();
    	 //System.out.println(total);
    	 Double totalCost = Double.parseDouble(total.replaceAll("[^\\d.]", ""));
    	 //Double totalCost = 100.0;
    	 //System.out.println(shippingCost);
    	 //System.out.println(subtotalActual);
    	 //System.out.println(totalCost);
    	 //Checkout_Page.verifyTotal(shippingCost, subtotalActual, totalCost);
    	 Checkout_Page.verifyTotalAssertion(shippingCost, subtotalActual, totalCost);
    	 Checkout_Page.purchaseButton(driver).click();
    	 //Thread.sleep(1000);
    	 driver.quit();
    	//Home_Page.productCategory_Link(driver).click();
    	//Home_Page.iPhoneCategory_Link(driver).click();
    	//Home_Page.productCategory_Link(driver).hov;
    	//action.moveToElement(Home_Page.productCategory_Link(driver)).perform();
    	//Home_Page.iPhoneCategory_Link(driver).click();
    	//Thread.sleep(4000);
    	//action.moveToElement(Home_Page.productCategory_Link(driver));
    	//By locator = By.linkText("iPhones");
    	//action.moveToElement(Home_Page.iPhoneCategory_Link(driver));
    	//action.click().build().perform();
        //System.out.println( "Hello World!" );
    }
    
    //The method points to the file path for and opens a new instance of the FireFox browser....
    private static WebDriver openBrowser() {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
    	File pathBinary = new File("C:\\Users\\Admin\\Downloads\\firefox-48.0.2.win64.sdk\\firefox-sdk\\bin\\firefox.exe");
    	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
    	FirefoxProfile firefoxProfile = new FirefoxProfile();
    	WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
    	return driver;
    }
    
}
