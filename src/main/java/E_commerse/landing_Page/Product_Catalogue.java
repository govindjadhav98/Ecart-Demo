package E_commerse.landing_Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import E_commerse.Abstractcomponents.Abstract_Components;
import net.bytebuddy.implementation.bind.annotation.Super;

public class Product_Catalogue extends Abstract_Components {

	WebDriver driver;

	public Product_Catalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = ".col-lg-4")
	List<WebElement> products;
	By products1=By.cssSelector(".col-lg-4");
	By Addtocart=By.cssSelector(".card-body button:last-of-type");
	By toast=By.cssSelector("#toast-container");
	
	@FindBy(css = ".card-body button:last-of-type")
	WebElement Addtocartbtn;

	public List<WebElement> getproductlist() throws InterruptedException {
		Thread.sleep(3000);
		WaitForElementtoApper(products1);
		return products;
	}
	public WebElement getproductByname(String productname) throws InterruptedException {
		WebElement prod = getproductlist().stream().filter(product->product.getText().contains(productname)).findFirst().orElse(null);
		return prod;

	}
	public void scrolltoProduct( WebElement product) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",product);
	}

	public void AddproductToCart(String productname) throws InterruptedException {
		WebElement prod = getproductByname(productname);
		
		
		WaitForElementtoApper(Addtocart);
		
		//Thread.sleep(3000);
	
		prod.findElement(Addtocart).click();
		WaitForElementtoApper(toast);
		WaitForElementtoDisApper(toast);
	}
}
