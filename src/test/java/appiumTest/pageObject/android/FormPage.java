package appiumTest.pageObject.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appiumTest.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	public AndroidDriver driver;
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
//	this is new way to store in page factory modal
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement genderFemale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement genderMale;
	
	@AndroidFindBy(xpath="//android.widget.Toast)[1]")
	private WebElement toastMessage;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countaryDropDown;
	
	
	
	public void setNameField(String Name) {
		nameField.sendKeys(Name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			genderMale.click();
		}
		else if(gender.equals("Female")) {
			genderFemale.click();
		}
	}
	
	public void setCountaryName(String countaryName) {
		countaryDropDown.click();
		scrollToText(countaryName);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\""+countaryName+"\"]")).click();
	}
	
	public void clickShopButton() {
		letsShopBtn.click();
	}
	
	
}
