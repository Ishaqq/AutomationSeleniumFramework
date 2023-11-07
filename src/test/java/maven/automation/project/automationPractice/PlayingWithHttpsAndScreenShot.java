package maven.automation.project.automationPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class PlayingWithHttpsAndScreenShot {

	public static void main(String[] args) throws IOException {
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
		driver.get("https://expired.badssl.com/");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Save the screenshot to a file
//		FileHandler.copy(src, new File("screenshot.png"));
		Files.copy(src, new File("screenshot.png"));
		

	}

}
