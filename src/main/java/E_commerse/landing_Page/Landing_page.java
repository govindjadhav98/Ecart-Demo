package E_commerse.landing_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E_commerse.Abstractcomponents.Abstract_Components;

public class Landing_page extends Abstract_Components {

	WebDriver driver;
	//	driver.get("https://rahulshettyacademy.com/client");
	//	driver.findElement(By.id("userEmail")).sendKeys("jadhavgovind8140@gmail.com");
	//	driver.findElement(By.id("userPassword")).sendKeys("Balasaheb@1");
	//	driver.findElement(By.id("login")).click();

	public Landing_page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement useremailele;

	@FindBy(id="userPassword")
	WebElement password;

	@FindBy(id="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errormessg;

	public void gotolandingpage() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public Product_Catalogue logintoApp(String useremail, String Password) {
		useremailele.sendKeys(useremail);
		password.sendKeys(Password);
		loginbtn.click();
		Product_Catalogue productcatelogue=new Product_Catalogue(driver);
		return productcatelogue;
	}
	public String geterrormessg() {
		WaitForWebElementtoApper(errormessg);
		String errortext = errormessg.getText();
		return errortext;
	}
}
