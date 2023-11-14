package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import graphql.com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException, InterruptedException {
		  service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				 .withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("ishaqPhone2");
//		options.setUdid("RF8R50J6C0V");
//		options.setDeviceName("MD ISHAQ's A32");
		options.setChromedriverExecutable("C:\\Users\\HP\\eclipse-workspace\\automationProject\\src\\test\\java\\appiumResources\\chromedriver.exe");
//		options.setApp("C:\\Users\\HP\\eclipse-workspace\\automationProject\\src\\test\\java\\appiumResources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\HP\\eclipse-workspace\\automationProject\\src\\test\\java\\appiumResources\\General-Store.apk");
//		options.setCapability("browserName", "chrome");
		URL serverUrl = new URI("http://127.0.0.1:4723").toURL();
		 driver = new AndroidDriver(serverUrl, options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),"duration",2000
			));
	}
	
	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
	}
	
	public void swipActions(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void dragActions(WebElement dragableEle, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) dragableEle).getId(),
			    "endX", x,
			    "endY", y
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
