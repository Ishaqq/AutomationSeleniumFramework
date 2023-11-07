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
import org.testng.annotations.Test;

import baseComponentsFramework3.BaseTest;
import pageObjectFrameWork3.CartPage;
import pageObjectFrameWork3.LandingPage;
import pageObjectFrameWork3.ProductCatalog;
//@Test(groups= {"Smoke"})

public class BuyProduct extends BaseTest {
	@Test
	public void standAloneTest() throws InterruptedException, IOException {
//		launchApplication();
		LandingPage lp=new LandingPage(driver);
		lp.loginApplication("test765@gmail.com", "Test1234");
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
		String prodName="ZARA COAT 3";
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
		driver.findElement(By.partialLinkText("Place Order")).click();
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		String[] itemsNeeded = { "ZARA COAT 3", "IPHONE 13 PRO"};
//		int j = 0;
//		List<String> itemsNeededList = null;
//		for (int i = 0; i < products.size(); i++) {
//			WebElement element=products.get(i).findElement(By.cssSelector("b"));
//			String formattedName = element.getText();
////			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
//			itemsNeededList = Arrays.asList(itemsNeeded);
//
//			if (itemsNeededList.contains(formattedName)) {
//				System.out.println(formattedName);
//				System.out.println("Befor button click");
//				Thread.sleep(5000);
////				WebElement addToCart=products.get(i).findElement(By.cssSelector(".card-body button:last-of-type"));
//				wait.until(ExpectedConditions.visibilityOf(products.get(i).findElement(By.cssSelector(".card-body button:last-of-type")))).click();
//				System.out.println("After button click");
//				j++;
//				// Add code here to click on the product if needed
//			}
//			if (j == itemsNeeded.length) {
//				break; // Exit the loop when all required items are found
//			}
//		}
//		System.out.println("Tested");
//		Thread.sleep(5000);
//		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
//		List<WebElement> cartElements=driver.findElements(By.cssSelector(".cartSection h3"));
//		List<String> cartElementList=cartElements.stream().map(s->s.getText()).collect(Collectors.toList());
//		
////		Boolean match=cartElements.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("test"));
////		Assert.assertTrue(match);
//		
//		//instead of above line we can do like this 
////		List<String> cartTextList = new ArrayList<String>();
////
////		for (WebElement element : cartElements) {
////		    cartTextList.add(element.getText());
////		}
//		if (itemsNeededList.equals(itemsNeededList)) {
//			System.out.println("Sorting column is working");
//		}
//		Assert.assertEquals(itemsNeededList, itemsNeededList);
		
		}
	}

}
