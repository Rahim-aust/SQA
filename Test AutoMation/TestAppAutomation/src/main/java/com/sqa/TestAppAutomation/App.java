package com.sqa.TestAppAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class App 
{
	public AndroidDriver driver;
	String resourceId, className, xPath, toFind;
	
	@BeforeTest
	public void setDevice( ) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:deviceName", "Pixel_emu");
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appium:udid", "emulator-5554");
		desiredCapabilities.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
		desiredCapabilities.setCapability("appActivity", "com.bs.ecommerce.main.SplashScreenActivity");

		URL remoteUrl = new URL("http://127.0.0.1:4723/");
	
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	@Test(priority = 1)
	public void app_test_1() throws InterruptedException {
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAccept")).click();
		Thread.sleep(1000);
		
		className = "androidx.recyclerview.widget.RecyclerView";
		resourceId = "com.nopstation.nopcommerce.nopstationcart:id/tvProductName";
		toFind = "Electronics";

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).className(\"" + className + "\")).setAsHorizontalList().scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").text(\"" + toFind + "\"))"));
		
		xPath = "//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Electronics\"]";
		driver.findElement(By.xpath(xPath)).click();
		Thread.sleep(1000);
		
		toFind = "Mattress Bedroom";
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + toFind + "\"))")).click();
		Thread.sleep(1000);

		toFind = "+";
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + toFind + "\"))")).click();
		Thread.sleep(1000);
			
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 2)
	public void app_test_2() throws InterruptedException {
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/counterIcon")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnCheckOut")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnGuestCheckout")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFirstName")).sendKeys("Test First Name");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etLastName")).sendKeys("Test Last Name");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etEmail")).sendKeys("testmail@gmail.com");
		Thread.sleep(1000);
		
		toFind = "Albania";
		className = "android.widget.Spinner";
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).className(\"" + className + "\")).scrollIntoView(new UiSelector().text(\"" + toFind + "\"))")).click();		
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCompanyName")).sendKeys("Test Company");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etCity")).sendKeys("Test City");
		Thread.sleep(1000);
		
		toFind = "CONTINUE";
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + toFind + "\"))"));
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress")).sendKeys("Test Street 1");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etStreetAddress2")).sendKeys("Test Street 2");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etZipCode")).sendKeys("1234");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etPhone")).sendKeys("01234567891");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/etFax")).sendKeys("Test Fax");
		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
		Thread.sleep(1000);
		
		resourceId = "com.nopstation.nopcommerce.nopstationcart:id/tvShippingMethodDescription";
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"" + resourceId + "\").instance(2)")).click();	
		Thread.sleep(1000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingToEnd(1000)"));
		Thread.sleep(1000);
		
		resourceId = "com.nopstation.nopcommerce.nopstationcart:id/btnContinue";
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingToEnd(1000)"));
		
		resourceId = "com.nopstation.nopcommerce.nopstationcart:id/tvPaymentMethodName";
		className = "android.widget.RelativeLayout";
		toFind = "Check / Money Order";
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).className(\"" + className + "\")).scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").text(\"" + toFind + "\"))")).click();;

		Thread.sleep(1000);
		
		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
		Thread.sleep(3000);

		className = "android.widget.Button";
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"" + className + "\")")).click();	
		Thread.sleep(1000);

		driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/btnContinue")).click();
		Thread.sleep(100000);      
		
		String msgVerify = driver.findElement(By.id("com.nopstation.nopcommerce.nopstationcart:id/md_text_message")).getText();
		Thread.sleep(1000);
		
		if(msgVerify.contains("Your order has been successfully processed!"))
			System.out.println("Verified successfully");

		Thread.sleep(2000);
	}
	
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
}
