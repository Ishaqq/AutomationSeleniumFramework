package frameworkPart3;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseComponentsFramework3.BaseTest;
import baseComponentsFramework3.Retry;
import pageObjectFrameWork3.CartPage;
import pageObjectFrameWork3.LandingPage;
import pageObjectFrameWork3.ProductCatalog;

public class BuyProduct2 extends BaseTest {
	@Test(dataProvider = "getData", groups = { "Smoke" }, retryAnalyzer=Retry.class)
	public void standAloneTest(String mail, String password) throws InterruptedException, IOException {
//		launchApplication();
//@BeforeTest is used in BaseClass
		LandingPage lp=new LandingPage(driver);
		lp.loginApplication(mail, password);
		WebElement errorToast=lp.errorToast();
		if (lp.isElementPresent(errorToast)) {
			String toastMessage = lp.errorMessage(); 
		    System.out.println("Toast Message: " + toastMessage);
		    Assert.assertEquals("Incorrect email or password.", lp.errorMessage());
			System.out.println("Incorrect email or password.");
		} else {
		   System.out.println("Do nothing");
		
		
		//div[@aria-label='Incorrect email or password.'] 
		ProductCatalog productCatalog=new ProductCatalog(driver);
		List<WebElement> products=productCatalog.getProductList();
		String prodName="IPHONE 13 PRO";
		productCatalog.addToCart(prodName);
		productCatalog.goToCart();
		CartPage cp=new CartPage(driver);
		Boolean match=cp.verifyProductDisplay(prodName);
		Assert.assertTrue(match);
		cp.goToCheckOut();
				Actions a =new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div/section/button[2]/span/i")).click();
		Thread.sleep(1000);
//		driver.findElement(By.partialLinkText("Place Order")).click();
		
		}
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"test765@gmail.com", "Test1234"},{"test765@gmail.com", "Test12345"}};
	}

}
