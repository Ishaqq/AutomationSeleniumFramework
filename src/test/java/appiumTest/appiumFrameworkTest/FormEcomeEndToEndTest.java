package appiumTest.appiumFrameworkTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.pageObject.android.CartPage;
import appiumTest.pageObject.android.FormPage;
import appiumTest.pageObject.android.ProductCatalougue;
import appiumTest.utils.BaseTestFramework;

public class FormEcomeEndToEndTest extends BaseTestFramework {
	@Test
	public void fillForm() throws InterruptedException {
		FormPage formPage=new FormPage(driver);
		formPage.clickShopButton();
		Assert.assertEquals(false, true);
		Thread.sleep(2000);

	}

}
