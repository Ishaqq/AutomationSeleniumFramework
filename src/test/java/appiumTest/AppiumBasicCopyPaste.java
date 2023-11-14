package appiumTest;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppiumBasicCopyPaste extends BaseTest {
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException, InterruptedException {
//		 AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//				 .withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName("ishaqPhone");
//		options.setApp("C:\\Users\\HP\\eclipse-workspace\\automationProject\\src\\test\\java\\appiumResources\\ApiDemos-debug.apk");
//		
//		URL serverUrl = new URI("http://127.0.0.1:4723").toURL();
//		AndroidDriver driver = new AndroidDriver(serverUrl, options);
//		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		Thread.sleep(5000);
//		driver.quit();
//		service.stop();
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[2]")).click();
		driver.findElement(By.id("android:id/edit")).sendKeys("TEST");
		driver.setClipboardText(driver.findElement(By.id("android:id/edit")).getText());
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
//		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		Thread.sleep(2000); 
		
	}
}
