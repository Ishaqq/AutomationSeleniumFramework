package maven.automation.project.automationPractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EndtoendTestcase {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsNeeded = { "Mango", "Pears", "Orange" };
		addItems(driver, itemsNeeded);
		
		Set<String> windows=driver.getWindowHandles(); 
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		Thread.sleep(2000);
		driver.switchTo().window(parentId);
		
//		WebElement iframeElement = driver.findElement(By.id("your-iframe-id"));
//		driver.switchTo().frame(iframeElement);
//		driver.switchTo().defaultContent();
		
	}
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='products']/div/h4"));
		for (int i = 0; i < products.size(); i++) {
			String[] itemNames = products.get(i).getText().split("-");
			String formattedName = itemNames[0].trim(); // Trim to remove leading/trailing spaces
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				System.out.println(formattedName);
				driver.findElements(By.xpath("//div[@class='products']//div[@class='product-action']")).get(i).click();
				j++;
				// Add code here to click on the product if needed
			}
			if (j == itemsNeeded.length) {
				break; // Exit the loop when all required items are found
			}
		}
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.linkText("Flight Booking"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//input[@type='search']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("Mango").build().perform();
		a.moveToElement(driver.findElement(By.linkText("Flight Booking"))).contextClick().build().perform();
		a.keyDown(Keys.LEFT_CONTROL).click().build().perform();

	}
}
