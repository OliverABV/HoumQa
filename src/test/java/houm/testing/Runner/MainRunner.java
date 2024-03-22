package houm.testing.Runner;


import org.junit.AfterClass;
import io.cucumber.java.After;
import org.junit.runner.RunWith;

import houm.testing.Page.Base;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(glue = { "houm.testing.Steps" },
				features = "src/test/resources/cucumber", 
				plugin = {"json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
				monochrome = true,
				stepNotifications = true,
				tags = "@Houm")

public class MainRunner {
	@AfterClass
	public static void cleanDriver() {
		Base.closeBrowser();
		}

}
