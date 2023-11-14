package appiumTest;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import graphql.com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {
	@Test
	public void longClickGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).flingToBeginning(1)"));
		Thread.sleep(3000);
		scrollToEndAction();
		Thread.sleep(3000);
	}
}