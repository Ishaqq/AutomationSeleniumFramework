package appiumTest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
public class BaseTestFramework {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws URISyntaxException, InterruptedException, IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\appiumResources\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		String port=prop.getProperty("port");
		String phoneName=prop.getProperty("AndroidDeviceName");
		
		  service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				 .withIPAddress(ipAddress).usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(phoneName);
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
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{
		String jsonContent=FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>(){
			});
		return data;
	}
	
	public String getScreenshotPath(String testCaseName, AndroidDriver driver ) throws IOException {
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		 FileUtils.copyFile(source, new File(destinationFile));
		 return destinationFile;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
