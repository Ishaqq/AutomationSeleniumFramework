package frameworkPart1;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class StreamProductList {
	public void standAloneTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id='userEmail']")).sendKeys("test765@gmail.com");
		driver.findElement(By.cssSelector("input[id='userPassword']")).sendKeys("Test1234");
		driver.findElement(By.cssSelector("input[id='login']")).click();
		List<WebElement> products=driver.findElements(By.className("mb-3"));
//		WebElement prod=products.stream().filter(product->product
//				.findElement(By.cssSelector("b")).getText()
//				.equals("ZARA COAT 3")).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
//		products.stream()
//        .filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
//        .forEach(product -> product.findElement(By.cssSelector(".card-body button:last-of-type")).click());
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		String[] itemsNeeded = { "ZARA COAT 3", "IPHONE 13 PRO"};
		int j = 0;
		List<String> itemsNeededList = null;
		for (int i = 0; i < products.size(); i++) {
//			String[] itemNames = products.get(i).getText().split("-");
//			String formattedName = itemNames[0].trim();
			WebElement element=products.get(i).findElement(By.cssSelector("b"));
			String formattedName = element.getText();
//			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				System.out.println(formattedName);
				System.out.println("Befor button click");
				Thread.sleep(5000);
//				WebElement addToCart=products.get(i).findElement(By.cssSelector(".card-body button:last-of-type"));
				wait.until(ExpectedConditions.visibilityOf(products.get(i).findElement(By.cssSelector(".card-body button:last-of-type")))).click();
				System.out.println("After button click");
				j++;
				// Add code here to click on the product if needed
			}
			if (j == itemsNeeded.length) {
				break; // Exit the loop when all required items are found
			}
		}
		System.out.println("Tested");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		List<WebElement> cartElements=driver.findElements(By.cssSelector(".cartSection h3"));
		List<Object> cartElementList=cartElements.stream().map(s->s.getText()).collect(Collectors.toList());
		
//		Boolean match=cartElements.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("test"));
//		Assert.assertTrue(match);
		
		//instead of above line we can do like this 
//		List<String> cartTextList = new ArrayList<String>();
//
//		for (WebElement element : cartElements) {
//		    cartTextList.add(element.getText());
//		}
		if (itemsNeededList.equals(itemsNeededList)) {
			System.out.println("Sorting column is working");
		}
		Assert.assertEquals(itemsNeededList, itemsNeededList);
	}
}
