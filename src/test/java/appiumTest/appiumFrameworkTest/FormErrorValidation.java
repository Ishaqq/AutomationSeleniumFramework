package appiumTest.appiumFrameworkTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.pageObject.android.CartPage;
import appiumTest.pageObject.android.FormPage;
import appiumTest.pageObject.android.ProductCatalougue;
import appiumTest.utils.BaseTestFramework;

public class FormErrorValidation extends BaseTestFramework {
	@Test
	public void fillForm() throws InterruptedException {
		FormPage formPage=new FormPage(driver);
		
		formPage.setNameField("Zunaisha Afridi");
		driver.hideKeyboard();
		formPage.setGender("Female");
		formPage.setCountaryName("Argentina");
		formPage.clickShopButton();
		Thread.sleep(2000);
		ProductCatalougue productCatalougue=new ProductCatalougue(driver);
		
		String[] itemsToAdd = {"Air Jordan 4 Retro", "Jordan 6 Rings"};
		for(String ItemsToAdd: itemsToAdd)
		{
			productCatalougue.addItemByCart(ItemsToAdd);
		}
		productCatalougue.goToCart();
		Thread.sleep(3000);
		
		CartPage cartPage=new CartPage(driver);
		cartPage.sumOfPrice();
		double sumOfTotalAmount=cartPage.sumOfPrice();
		System.out.println(sumOfTotalAmount);
		double totalAmount=cartPage.getTotalAmount();
		Assert.assertEquals(sumOfTotalAmount, totalAmount);
		cartPage.clickCheckbox();
		cartPage.submitForm();
		Thread.sleep(3000);

	}

}
