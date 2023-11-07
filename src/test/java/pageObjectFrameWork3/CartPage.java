package pageObjectFrameWork3;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponentFramework3.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartElements;
	
	@FindBy(css=".totalRow  button")
	WebElement checkOutEle;

//	List<String> cartElementList=cartElements.stream().map(s->s.getText()).collect(Collectors.toList());
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartElements.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
//		Assert.assertTrue(match);
		return match;
	}
	
	public void goToCheckOut() {
		checkOutEle.click();
	}

}
