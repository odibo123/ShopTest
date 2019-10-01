package shoptepDef;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ShopStepDefinition extends TestBase{
	@Before
	public void setUp() throws IOException{
		initialize();
	}

@Given("^user goes to Home Page$")
public void user_goes_to_Home_Page() throws Throwable {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
driver.get(CONFIG.getProperty("URL"));


String title = driver.getTitle();
System.out.println("title of the page "+ title);	 
Assert.assertTrue(driver.getTitle().contains("ToolsQA Demo Site"));

List <WebElement> links=driver.findElements(By.tagName("a"));
int count=links.size();
System.out.println("Total number of links"+ count);
}

@Given("^he clicks the search icon$")
public void he_clicks_the_search_icon() throws Throwable {
	 driver.findElement(By.xpath("//*[@id='noo-site']/header/div[2]/div/a")).click(); 
}

@Given("^he types shoes in the enter text field$")
public void he_types_shoes_in_the_enter_text_field() throws Throwable {
	driver.findElement(By.xpath("//*[@id='noo-site']/header/div[3]/div[2]/form/input[1]")).sendKeys( "shoe");  
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@id='noo-site']/header/div[3]/div[2]/form/input[1]")).sendKeys(Keys.RETURN);
	  Thread.sleep(5000);
}

@Given("^searches for description and item and price$")
public void searches_for_description_and_item_and_price() throws Throwable {
	String title =driver.getTitle();
	System.out.println("the title of my product page is "+title );
	String b1= driver.findElement(By.xpath("//*[@id='product-1301']/div[1]/div[2]/h1")).getText();
	System.out.println(b1);
String b2= driver.findElement(By.xpath("//*[@id='product-1301']/div[1]/div[2]/p/span")).getText();
	System.out.println(b2);
	boolean b3= driver.findElement(By.xpath("//*[@id='product-1301']/div[1]/div[1]/div[2]/div/div/div/div[2]/img")).isDisplayed();
	System.out.println(b3);
}

@Given("^chooses to buy the first item$")
public void chooses_to_buy_the_first_item() throws Throwable {

	Select colour = new Select(driver.findElement(By.id("pa_color")));
	colour.selectByVisibleText("Nude");
	
	Select size = new Select(driver.findElement(By.id("pa_size")));
	size.selectByVisibleText("36");
	
	 driver.findElement(By.xpath("//i[@class='icon_plus']")).click(); 
	 
	 driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();
}

@Given("^clicks on cart link$")
public void clicks_on_cart_link() throws Throwable {
	 driver.findElement(By.xpath("	//span[@class='cart-name-and-total']")).click();
}

@Given("^user clicks proceed to checkout$")
public void user_clicks_proceed_to_checkout() throws Throwable {
	 driver.findElement(By.xpath("//*[@id='post-6']/div/div/div[2]/div[2]/div/a")).click();
String text =  driver.getTitle();
System.out.println("The title of cart page "+text);
}

@Given("^enters personal details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"and \"([^\"]*)\"   on checkout Page$")
public void enters_personal_details_and_and_and_and_and_and_on_checkout_Page(String firstname, String lastname, String address, String town, String postcode, String phone, String email) throws Throwable {
	   driver.findElement(By.id("billing_first_name")).sendKeys(firstname);
	   driver.findElement(By.id("billing_last_name")).sendKeys(lastname);
	   driver.findElement(By.id("billing_address_1")).sendKeys( address);
	   driver.findElement(By.id("billing_city")).sendKeys(town);
		driver.findElement(By.id("billing_postcode")).sendKeys(postcode);
		driver.findElement(By.id("billing_phone")).sendKeys(phone);
		driver.findElement(By.id("billing_email")).sendKeys(email);
		Thread.sleep(5000);
String title=driver.getTitle();
System.out.println("The title of Checkout page is " +title  );
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)");  	
		Thread.sleep(5000);
driver.findElement(By.xpath("//input[@id='terms']")).click();
}

@Given("^place the order$")
public void place_the_order() throws Throwable {
	 driver.findElement(By.id("place_order")).click();
	 Thread.sleep(1000);
}

@Then("^user confirms seeing order details$")
public void user_confirms_seeing_order_details() throws Throwable {
	
	String confirmMessage = driver.findElement(By.xpath("//div[@class='noo-checkout-complete']")).getText(); 
	System.out.println(confirmMessage);
	
	Thread.sleep(2000);
	driver.manage().deleteAllCookies();
}

}
