package appiumTest;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class Rotation extends BaseTest {
	@Test
	public void rotation() throws InterruptedException {
		DeviceRotation landScape=new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		Thread.sleep(2000);
	}
}
