package maven.automation.project.automationPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SpicejetSelectors {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers\"]/div/div[1]")).click();
		WebElement plusIcon = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
//		for(int i=1; i<=5; i++) {
//			plusIcon.click();
//		}
		int i = 1;
		while (i < 5) {
			plusIcon.click();
			i++;
		}
		driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers\"]/div/div[1]")).click();
		String adultCount = driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers\"]/div/div[1]"))
				.getText();
		String[] adultCount1 = adultCount.split(" ");
		for (String adult : adultCount1) {
			System.out.println(adult);
		}
		int adult = Integer.parseInt(adultCount1[0]);
		Assert.assertEquals(5, adult);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div[text()='From']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for up to 10 seconds
		List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']/div[2]/div[2]/div[2]/div/div/div/div")));
//		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']/div[2]/div[2]/div[2]/div/div/div/div"));
		for (WebElement city : elements) {
			if (city.getText().equals("Kochi")) {
				System.out.println(city.getText());
				city.click();
				break;
			}
		}
		Thread.sleep(3000);
		List<WebElement> elements2= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath("//div[@class='css-1dbjc4n r-b5h31w r-95jzfe']/div[2]/div[2]/div[2]/div/div/div/div")));
//		int maxRetries = 3;
//		for (int retry = 0; retry < maxRetries; retry++) {
//		    try {
//		        WebElement city = elements2.get(0); // Re-locate the element if needed
//		        if (city.getText().equals("Kochi")) {
//		            System.out.println(city.getText());
//		            city.click();
//		            break;
//		        }
//		    } catch (StaleElementReferenceException e) {
//		        System.out.println("element not found");
//		    }
//		}

		for (WebElement city : elements2) {
			if (city.getText().equals("Ajmer")) {
				System.out.println(city.getText());
				city.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
