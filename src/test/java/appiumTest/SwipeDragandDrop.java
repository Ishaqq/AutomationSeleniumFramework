package appiumTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebElement;
import graphql.com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

@Test
public class SwipeDragandDrop extends BaseTest {
	public void swipeGestureandDragandDrop() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		WebElement firstImage=driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		//pinchOpen
//		 driver.executeScript("mobile: pinchOpen", ImmutableMap.of(
//		            "element", ((RemoteWebElement) firstImage).getId(),
//		            "percent", 1, // You can adjust the percent value based on your requirement
//		            "steps", 100 // You can adjust the steps value based on your requirement
//		        ));
		
		Assert.assertEquals(firstImage.getAttribute("focusable"), "true");
		swipActions(firstImage,"left");
		Assert.assertEquals(firstImage.getAttribute("focusable"), "false");
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		//Drag and drop gestures
		WebElement dragableEle=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		dragActions(dragableEle,659,583);
		String text=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		
		Assert.assertEquals(text, "Dropped!");
		
		
	}
}
