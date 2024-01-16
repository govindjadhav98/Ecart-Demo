package Cross_Browsertest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cross_Browser {

	@Test
	public void crosstest() throws MalformedURLException {
		
		MutableCapabilities caps=new MutableCapabilities();
		
WebDriver driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
		
		driver.get("https://www.amazon.in/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Online shopping site in India"));
		
	}
}
