package pageObjectFrameWork3;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public void loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		userLoginBtn.click();
	}

	public void goToApplication() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorMessage() {
		WaitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public WebElement errorToast() {
		return errorMessage;
	}
	
	public boolean isElementPresent(WebElement element) {
        try {
            // Attempt to interact with the element to check its presence
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            // Element is not present
            return false;
        }
    }
}
