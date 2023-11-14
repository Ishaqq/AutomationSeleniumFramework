package appiumTest.pageObject.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appiumTest.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

//	accessibilty Id can be targeted like 
//	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"productAddCart\")")
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\"]")
	private List<WebElement> price;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement goToCartButton;

	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")
	private WebElement totalAmount;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement submitButton;
	
	public double sumOfPrice() throws InterruptedException {
		int priceCount = price.size();
		double sumOfPrice = 0;
		for (int i = 0; i < priceCount; i++) {
			String PriceString=price.get(i).getText();
			String trimmedPrice = PriceString.replaceAll("[^0-9.]+", "");
			 double trimpriceDouble = Double.parseDouble(trimmedPrice);
			 sumOfPrice=sumOfPrice+trimpriceDouble;
		}
		return sumOfPrice;
	}
	
	public double getTotalAmount() {
		String stringAmount=totalAmount.getText();
		String trimAmount=stringAmount.replaceAll("[^0-9.]+", "");
		double totalAmount=Double.parseDouble(trimAmount);
		return totalAmount;
	}
	public void clickCheckbox() {
		checkBox.click();
	}
	
	public void submitForm() {
		submitButton.click();
	}
}