package maven.automation.project.automationPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBrokenLink {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		String url=driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
//		HttpURLConnection conn = (HttpURLConnection) new URI.toURL(url).openConnection();
//		URI url1 = new URI(url);
//		  HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		  HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
	        conn.setRequestMethod("HEAD");
	        conn.connect();
	        System.out.println(conn.getResponseCode());
	        conn.disconnect();
	        
	        List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	        for(WebElement link: links) {
	        	String urlAll=link.getAttribute("href");
	        	HttpURLConnection conn2 =(HttpURLConnection) new URL(urlAll).openConnection();
		        conn2.setRequestMethod("HEAD");
		        conn2.connect();
		        if(conn2.getResponseCode()>400) {
		        System.out.println(conn2.getResponseCode());
		        System.out.println(link.getText());
		        }
	        }
	        conn.disconnect();
	}

}
