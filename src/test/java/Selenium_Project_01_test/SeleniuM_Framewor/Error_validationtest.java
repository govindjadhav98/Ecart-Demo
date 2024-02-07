package Selenium_Project_01_test.SeleniuM_Framewor;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import E_commerse.landing_Page.Cartpage;
import E_commerse.landing_Page.Landing_page;
import E_commerse.landing_Page.Product_Catalogue;
import E_commersetest.AbstratctCopmponents.Basetest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Story("Login error validations")
@Severity(SeverityLevel.CRITICAL)
public class Error_validationtest extends Basetest{

	@Test (groups = {"Error Validations"}, retryAnalyzer = E_commersetest.AbstratctCopmponents.Retry.class)
	public void loginerrortest() throws IOException {
		
		lpage.logintoApp("gjadhav12345@gmail.com", "Balasaheb@1");
		
		Assert.assertTrue(lpage.geterrormessg().equals("Incorrect email or password.. new"));
	}
	
	@Test (groups = {"Error Validations"})
	public void producterrortest() throws InterruptedException {
		String productname="IPHONE 13 PRO";
		
		Product_Catalogue productpage = lpage.logintoApp("jadhavgovind8140@gmail.com", "Balasaheb@1");
		List<WebElement> productlist = productpage.getproductlist();
		 productpage.AddproductToCart(productname);
		 Cartpage Cartpage = productpage.gotocart();
		 
		 Assert.assertFalse(Cartpage.productpresentincart("ADIDAS ORIGINALl"));
	
	}
}
