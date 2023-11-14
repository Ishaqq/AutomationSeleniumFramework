package appiumTest.appiumFrameworkTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import appiumTest.pageObject.android.FormPage;
import appiumTest.utils.BaseTestFramework;

public class DataDrivenEndToEnd extends BaseTestFramework {
	@Test(dataProvider = "getData")
//	public void fillForm(String name,String gender, String country) throws InterruptedException {
	public void fillForm(HashMap<String, String> input) throws InterruptedException {
		FormPage formPage = new FormPage(driver);

//		formPage.setNameField(name);
		formPage.setNameField(input.get("name"));
		driver.hideKeyboard();
		formPage.setGender(input.get("gender"));
		formPage.setCountaryName(input.get("country"));
//		formPage.clickShopButton();
		Thread.sleep(2000);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\appiumResources\\ecommerece.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
//		return new Object[][] {{"Ishaq", "Male", "Argentina"},{"Zunaishah", "Female", "Pakistan"}};

	}

}
