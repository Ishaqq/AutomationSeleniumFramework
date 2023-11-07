package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/java/cucumber", // Specify the full path to the feature file
	    glue = "stepDefinitions", // Package where your step definitions are located
	    monochrome = true,
	    plugin = {"pretty", "html:target/cucumber-reports"}
	)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
