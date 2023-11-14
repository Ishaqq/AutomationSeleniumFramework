package appiumTest;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class appPackageandActivity extends BaseTest {
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		//adb shell dumpsys window | find "mCurrentFocus"
//		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
//		driver.startActivity(activity);
		driver.findElement(By.id("android:id/checkbox")).click();
	}
}
