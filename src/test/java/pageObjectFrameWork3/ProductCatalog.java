package pageObjectFrameWork3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponentFramework2.AbstractComponents;

public class ProductCatalog extends AbstractComponents {
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(className="mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By productsNameBy=By.cssSelector("b");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.id("toast-container");
	
	public List<WebElement> getProductList() {
		WaitForElementToAppear(productsBy);
		return products;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod=getProductList().stream().filter(product->product
				.findElement(productsNameBy).getText()
				.equals(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addToCart(String productName) {
		getProductByName(productName).findElement(addToCart).click();
		WaitForElementToAppear(toastMessage);
		WaitForElementToDisappear(spinner);
	}
}
