package maven.automation.project.automationPractice;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParacticalStreamPrac {
	@Test
	public void streamPrac() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		List<Object> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<Object> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		if (originalList.equals(sortedList)) {
			System.out.println("Sorting column is working");
		}
		Assert.assertEquals(originalList, sortedList);
		List<Object> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.xpath("//li/a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

//		do {
//			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
//			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
//					.collect(Collectors.toList());
//			price.forEach(a -> System.out.println(a));
//			if (price.size() < 1) {
//				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
//			}
//		} while (price.size() < 1);
		//searching filtring
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList=veggies.stream().filter(veggie->veggie.getText()
				.contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(veggies.size(), filteredList.size());
	}

	private Object getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
