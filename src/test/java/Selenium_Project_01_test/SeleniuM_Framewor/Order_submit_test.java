package Selenium_Project_01_test.SeleniuM_Framewor;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import E_commerse.Pageobject.OrderPage;
import E_commerse.landing_Page.Cartpage;
import E_commerse.landing_Page.Checkout_page;
import E_commerse.landing_Page.Confirmation_page;
import E_commerse.landing_Page.Landing_page;
import E_commerse.landing_Page.Product_Catalogue;
import E_commersetest.AbstratctCopmponents.Basetest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Story("Place Order")
@Severity(SeverityLevel.CRITICAL)
public class Order_submit_test extends Basetest {

	String Productname="IPHONE 13 PRO";

	@Test (dataProvider = "getdata",groups= {"datatest"})
	public void ordersubmittest(String mail,String password,String productname) throws InterruptedException, IOException {



		Product_Catalogue productcatelogue = lpage.logintoApp(mail, password);

		List<WebElement> products = productcatelogue.getproductlist();
		
		productcatelogue.AddproductToCart(productname);
		Cartpage cartpage = productcatelogue.gotocart();

		Assert.assertTrue(cartpage.productpresentincart(productname));

		Checkout_page checkoutpage = cartpage.gotoCheoutpage();
		checkoutpage.selectcountry("India");
		Confirmation_page Confirmationpage = checkoutpage.placeorder();
		String message = Confirmationpage.getconfirmationmessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test (dependsOnMethods = {"ordersubmittest"})

	public void orderhistorytest()  {

		Product_Catalogue productcatelogue = lpage.logintoApp("jadhavgovind8140@gmail.com", "Balasaheb@1");
		OrderPage Ordpage = productcatelogue.gotoorderpage();

		Assert.assertTrue(Ordpage.isproductaddedinorderlist(Productname));

	}
	
	@DataProvider
	public Object[][] getdata() throws IOException {
		
		DataFormatter formatter=new DataFormatter();
		
		FileInputStream file=new FileInputStream("C:\\Users\\Govind Jadhav\\Documents\\TestDemo.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
//		String value=workbook.create(file).getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
		XSSFSheet sheet = workbook.getSheet("Testdata");

		int Rowcount = sheet.getLastRowNum();
		
		System.out.println(Rowcount);
		
		
		int Cellcount = sheet.getRow(0).getLastCellNum();
		System.out.println(Cellcount);
		Object[][] ar= new Object[Rowcount][Cellcount];
		
		for (int i=0;i<Rowcount;i++) {
			int row=i+1;
			
			for (int j=0;j<Cellcount;j++) {
				
				ar[i][j]=formatter.formatCellValue(sheet.getRow(row).getCell(j));
				
			}
		}
//		HashMap <String,String> hmap=new HashMap();
//		hmap.put("email", "jadhavgovind8140@gmail.com");
//		hmap.put("password", "Balasaheb@1");
//		hmap.put("productname", "ADIDAS ORIGINAL");
//		
//		HashMap <String,String> hmap1=new HashMap();
//		hmap1.put("email", "govind1234@gmail.com");
//		hmap1.put("password", "Automation@1");
//		hmap1.put("productname", "ZARA COAT 3");
		return ar;
	}
}

