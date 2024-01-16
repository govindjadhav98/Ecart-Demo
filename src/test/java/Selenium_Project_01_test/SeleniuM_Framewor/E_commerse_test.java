package Selenium_Project_01_test.SeleniuM_Framewor;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class E_commerse_test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("jadhavgovind8140@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Balasaheb@1");
		driver.findElement(By.id("login")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

		//	for(WebElement product:products) {
		//		String productName = product.getText();
		//		System.out.println(productName);
		//	}

		WebElement reqproduct = products.stream().filter(product->product.getText().contains("IPHONE 13 PRO")).findFirst().orElse(null);

		System.out.println(reqproduct.getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",reqproduct);

Thread.sleep(3000);

		reqproduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		WebElement title=driver.findElement(By.xpath("//h3"));
		js.executeScript("arguments[0].scrollIntoView();", title);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-shopping-cart']")));
		//driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();

		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")));

		List<WebElement> cartItems = driver.findElements(By.xpath("//ul[@class='cartWrap ng-star-inserted']"));


		boolean cartitem = cartItems.stream().anyMatch(item->item.getText().contains("IPHONE 13 PRO"));

		Assert.assertTrue(cartitem);

driver.findElement(By.xpath("//button[text()='Checkout']")).click();


Actions al=new Actions(driver);


al.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));	
al.moveToElement(driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]"))).click().build().perform();
	
driver.findElement(By.xpath("//a[text()='Place Order ']")).click();

String confirmmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	Assert.assertTrue(confirmmsg.contains("THANKYOU FOR THE ORDER"));
	driver.close();
	
	}






}
