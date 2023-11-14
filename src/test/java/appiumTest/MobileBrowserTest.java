package appiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest {
	@Test
	public void mobBrowserTest() {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("ishaqafridi");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
}
