package testingPractice.JustDoIt;

import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.asserts.SoftAssert;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class CheckBrokenLinks {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();

		try {
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
			HttpClient httpClient = HttpClient.newHttpClient();

			for (WebElement link : links) {
				String url = link.getAttribute("href");

				try {
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url))
							.method("HEAD", HttpRequest.BodyPublishers.noBody()).build();

					HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());
					int respCode = response.statusCode();
					System.out.println(url + " " + respCode);
					softAssert.assertTrue(respCode < 400,
							"The link with Text '" + link.getText() + "' is broken with code " + respCode);
				} catch (Exception e) {
					System.out.println("Exception occurred for URL: " + url + " - " + e.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

		softAssert.assertAll(); // Assert all soft assertions
	}
}
