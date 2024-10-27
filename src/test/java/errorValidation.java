package testingPractice.JustDoIt;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.ProductCatalog;
import testComponents.BaseClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;


public class errorValidation extends BaseClass {
	@Test(dataProvider = "getData")
    public void shouldAnswerWithTrue(HashMap<String, String> userData) throws InterruptedException, IOException {
		LandingPage lp=new LandingPage(driver);
//		lp.goToLoginPage();
		lp.loginToApplication(userData.get("email"), userData.get("password"));
		Thread.sleep(1000);
		String text=driver.findElement(By.cssSelector("[class*='toast-error']")).getText();
		Assert.assertEquals("Incorrect email or password.", text);
		
		System.out.println(text);
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"test765@gmail.com", "Test12345"}};
//	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), new TypeReference<List<HashMap<String, String>>>() {});
    }

    
    @DataProvider
    public Object[][] getData() throws IOException {
        String filePath = Paths.get(System.getProperty("user.dir"), "\\src\\test\\java\\resources\\loginData.json").toString();
        System.out.println("Data.json file path: " + filePath); // Debugging output to verify path

        List<HashMap<String, String>> data = getJsonDataToMap(filePath);
 //       return new Object[][] { { data.get(0) }, { data.get(1) } };
        return new Object[][] { { data.get(0) } };
    }
	
	
}
