package E_commerse.Pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E_commerse.Abstractcomponents.Abstract_Components;

public class OrderPage extends Abstract_Components {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//tr//td[2]")
	List<WebElement> ProductName;

	public boolean isproductaddedinorderlist(String productname) {
		boolean match = ProductName.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
	return match;
	}

	
}
