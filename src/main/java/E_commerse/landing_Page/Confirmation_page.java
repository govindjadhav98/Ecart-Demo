package E_commerse.landing_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation_page {
	
	WebDriver driver;

	public Confirmation_page(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement Confirmationmessage;

	
	public String getconfirmationmessage() {
		String message = Confirmationmessage.getText();
		return message;
	}
}
