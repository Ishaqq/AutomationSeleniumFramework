package maven.automation.project.automationPractice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Selectors {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("ishfaq123@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("tes123");
//		driver.findElement(By.className("signInBtn")).click();
		//driver.findElement(By.cssSelector("button.submit.signInBtn")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
//		Thread.sleep(1000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
		
//		Wait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(2))
//                .pollingEvery(Duration.ofMillis(300))
//                .ignoring(ElementNotInteractableException.class);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.error")));
		

		String error=driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(error);	
		Assert.assertEquals(error,"* Incorrect username or password", "Message will displayed if fail");
//		 SoftAssert softAssert = new SoftAssert();  
//		 softAssert.assertEquals(error,"* mmmm text username or password");
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.partialLinkText("Forgot")).click();		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Testing");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("testing@gmail.com");
		driver.quit();
	}

}
