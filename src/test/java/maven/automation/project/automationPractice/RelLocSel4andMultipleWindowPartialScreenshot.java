package maven.automation.project.automationPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelLocSel4andMultipleWindowPartialScreenshot {
	@Test
	public void locatorPr() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> wh=driver.getWindowHandles();
		Iterator<String> it=wh.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
		WebElement nameEditbox=driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
		driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText();
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		nameEditbox.sendKeys("Testing webDriver");
		File file=nameEditbox.getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("logo.png"));
		
	}

}
