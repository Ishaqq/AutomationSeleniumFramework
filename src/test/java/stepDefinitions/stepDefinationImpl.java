package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseComponentsFramework3.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectFrameWork3.CartPage;
import pageObjectFrameWork3.LandingPage;
import pageObjectFrameWork3.ProductCatalog;

public class stepDefinationImpl extends BaseTest {
	public LandingPage landingPage;
	public ProductCatalog productCatalogue;
	public CartPage cartPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}
	 @Given("^Logged in with username (.+) and password (.+)$")
	 public void Logged_in_with_username_and_password (String name, String password) {
		landingPage.loginApplication(name, password);
	 }
	 @When ("^I add product (.+) from Cart$")
	 public void I_add_productName_from_Cart(String productName) {
		 List<WebElement> products=productCatalogue.getProductList();
		 productCatalogue.addToCart(productName);
	 }
	 @When("^Checkout (.+) and submit order$")
	 public void Checkout_product_and_submit_order(String productName) {
		 productCatalogue.goToCart();
			CartPage cp=new CartPage(driver);
			Boolean match=cp.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			cp.goToCheckOut();
	 }
	 @Then("{string} message is displayed on confirmation Page")
	 public void message_is_displayed_on_confirmation_Page(String Message) {
		 System.out.println(Message);
	 }
}
