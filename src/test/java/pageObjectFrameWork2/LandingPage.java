package pageObjectFrameWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponentFramework2.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement userEmail=driver.findElement(By.cssSelector("input[id='userEmail']"));
	@FindBy(css="input[id='userEmail']")
	WebElement userEmail;
	public WebElement userEmail() {
		return userEmail;
	}
	
	@FindBy(css="input[id='userPassword']")
	WebElement userPassword;
	
	@FindBy(css="input[id='login']")
	WebElement userLoginBtn;
	
	public void loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		userLoginBtn.click();
	}

}
