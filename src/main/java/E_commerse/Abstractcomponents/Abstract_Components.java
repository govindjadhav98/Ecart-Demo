package E_commerse.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import E_commerse.Pageobject.OrderPage;
import E_commerse.landing_Page.Cartpage;
import E_commerse.landing_Page.Checkout_page;

public class Abstract_Components {

	WebDriver driver;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement Checkoutbtn;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement Orderspage;

	public Abstract_Components(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void WaitForElementtoApper(By findby) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void WaitForWebElementtoApper(WebElement findby) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	public void WaitForElementtoDisApper(By findby) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public Cartpage gotocart() {
		cart.click();
		
		Cartpage cartpage=new Cartpage(driver);
		return cartpage;
	}
	public Checkout_page gotoCheoutpage() {
		
		Checkoutbtn.click();
		Checkout_page checkoutpage=new Checkout_page(driver);
		return checkoutpage;
	}
	public OrderPage gotoorderpage() {
		Orderspage.click();
		OrderPage OrderPage=new OrderPage(driver);
		return OrderPage;
	}
}
