package E_commerse.landing_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import E_commerse.Abstractcomponents.Abstract_Components;

public class Checkout_page extends Abstract_Components {

	 WebDriver driver;

	public Checkout_page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Country_filed;

	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeorderbtn;
	
	@FindBy(xpath="(//section[@class='ta-results list-group ng-star-inserted']/button)[2]")
	WebElement selectedcountry;
	
	By countrylist= By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	
	public void selectcountry(String Country) {
		Country_filed.sendKeys(Country);
		WaitForElementtoApper(countrylist);
		selectedcountry.click();
	

	}
	
	public Confirmation_page placeorder() {
		placeorderbtn.click();
		Confirmation_page confirmationpage=new Confirmation_page(driver);
		return confirmationpage;
	}
	
}
