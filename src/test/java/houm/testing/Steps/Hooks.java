package houm.testing.Steps;

import houm.testing.Page.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	 @Before
	    public void setup() {
	        Base.openBrowser();
	    }

    @After(order = 0)
    public void cleanDriver() {
        Base.closeBrowser();
    }
    
    @After(order = 1)
	public void TakesScreenshotOnFail(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) Base.driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
		}
	}
}
