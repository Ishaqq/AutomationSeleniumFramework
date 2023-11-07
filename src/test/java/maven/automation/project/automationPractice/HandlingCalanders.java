package maven.automation.project.automationPractice;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HandlingCalanders {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize(); 
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ja");
//		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		List<WebElement> sugestiveDdown = wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='ui-menu-item-wrapper']")));
//		List<WebElement> sugestiveDdown=driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));
		for (WebElement dD : sugestiveDdown) {
			if (dD.getText().contains("Japan")) {
				System.out.println(dD.getText());
				dD.click();
				break;
			}
		}
		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();
		System.out.println((driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).isSelected()));
		Assert.assertTrue((driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).isSelected()));
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		driver.quit();
	}

}
