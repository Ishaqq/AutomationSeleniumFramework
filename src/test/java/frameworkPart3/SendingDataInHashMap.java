package frameworkPart3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import baseComponentsFramework3.BaseTest;
import pageObjectFrameWork3.CartPage;
import pageObjectFrameWork3.LandingPage;
import pageObjectFrameWork3.ProductCatalog;

public class SendingDataInHashMap extends BaseTest {
	@Test(dataProvider = "getData", groups = { "Smoke" })
	public void standAloneTest(HashMap<String, String> userData) throws InterruptedException, IOException {
//		launchApplication();
//@BeforeTest is used in BaseClass
		String email = userData.get("email");
	    String password = userData.get("password");
		LandingPage lp = new LandingPage(driver);
		lp.loginApplication(email, password);
		WebElement errorToast = lp.errorToast();
		if (lp.isElementPresent(errorToast)) {
			String toastMessage = lp.errorMessage();
			System.out.println("Toast Message: " + toastMessage);
			Assert.assertEquals("Incorrect email or password.", lp.errorMessage());
			System.out.println("Incorrect email or password.dfsd");
		} else {
			System.out.println("Do nothing");
		}
//		getScreenshot("buyProduct");
	}
	
//	public void getScreenshot(String testCaseName) throws IOException {
////		TakesScreenshot ts=(TakesScreenshot) driver;
////		File source=ts.getScreenshotAs(OutputType.FILE);
////		File file=new File(System.getProperty("user.dir"+"\\reports"+testCaseName+".png"));
////		FileUtils.copyFile(source,file);
////		return System.getProperty("user.dir") + "//reports" + testCaseName + ".png";
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);;
//		FileUtils.copyFile(src, new File(testCaseName+".png"));
//	}

	@DataProvider
	public Object[][] getData() throws IOException {
	    HashMap<String, String> map1 = new HashMap<String, String>();
	    map1.put("email", "test765@gmail.com");
	    map1.put("password", "Test1234");
	    List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Data.json");

	    return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	
//	@DataProvider
//	public Object[][] getData() {
//	    HashMap<String, String> map1 = new HashMap<String, String>();
//	    map1.put("email", "test765@gmail.com");
//	    map1.put("password", "Test1234");
//
//	    HashMap<String, String> map2 = new HashMap<String, String>();
//	    map2.put("email", "test765@gmail.com");
//	    map2.put("password", "Test12345");
//
//	    return new Object[][] { { map1 }, { map2 } };
//	}

}
