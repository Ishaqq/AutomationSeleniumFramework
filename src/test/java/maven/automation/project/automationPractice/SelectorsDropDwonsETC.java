package maven.automation.project.automationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectorsDropDwonsETC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropDown=new Select(dropdown);
		dropDown.selectByIndex(1);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByValue("option2");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		dropDown.selectByVisibleText("Option3");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		driver.navigate().to("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers\"]/div/div[1]")).click();

	}

}
