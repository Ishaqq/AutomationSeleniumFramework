package gridServer;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	@Test
	public void HomePageCheck() throws MalformedURLException {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setBrowserName("firefox");
	    caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); // Corrected the syntax
	    RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.16.118.199:4444/wd/hub"), caps); 
	    driver.get("https://www.selenium.dev/downloads/");
	}
}
