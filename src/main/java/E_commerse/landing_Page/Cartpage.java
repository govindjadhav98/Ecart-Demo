package E_commerse.landing_Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import E_commerse.Abstractcomponents.Abstract_Components;

public class Cartpage extends Abstract_Components {

	 WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> cartitemlist;

	public boolean productpresentincart(String productname) {
		boolean ispresentinacart = cartitemlist.stream().anyMatch(product->product.getText().equalsIgnoreCase(productname));
	return ispresentinacart;
	}
}
