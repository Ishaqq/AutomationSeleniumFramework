package appiumTest.pageObject.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import appiumTest.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalougue extends AndroidActions {
	AndroidDriver driver;

	public ProductCatalougue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

//	accessibilty Id can be targeted like 
//	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"productAddCart\")")
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	private List<WebElement> products;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement goToCartButton;

	public void addItemByCart(String productName) throws InterruptedException {
		scrollToText(productName);

		int productCount = products.size();
		System.out.println(productCount);

		for (int i = 0; i < productCount; i++) {
			String productName1 = products.get(i).getText();
			if (productName1.equalsIgnoreCase(productName)) {
				addToCart.get(i).click();
				break;
			}
		}
	}

	public void goToCart() {
		goToCartButton.click();
	}
}