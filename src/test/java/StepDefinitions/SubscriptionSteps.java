package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class SubscriptionSteps {

//	WebDriver driver = new ChromeDriver();

	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/abuba/eclipse-workspace/CucumberTest/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	
	
	@Given("I navigate to the STC TV subscription page")
	public void i_navigate_to_the_stc_tv_subscription_page() {

		//System.setProperty("webdriver.chrome.driver",
	//			"C:/Users/abuba/eclipse-workspace/CucumberTest/src/test/resources/drivers/chromedriver.exe");
		driver.get("https://subscribe.stctv.com/sa-en?");
		driver.findElement(By.xpath("//div[@class='country-current']")).click(); 

	}

	@When("I select the country {string}")
	public void i_select_the_country(String country) {
		if (country.equals("KSA")) {
			 driver.findElement(By.xpath("//*[@id=\"sa\"]")).click(); 
		}else if (country.equals("Kuwait")) {
			driver.findElement(By.xpath("//*[@id=\"kw\"]")).click();
		}else if (country.equals("Bahrain")) {
			driver.findElement(By.xpath("//*[@id=\"bh\"]")).click();
		}									
	}
	
	@Then("I should see the {string} and {string} against {string} Plan A:")
	public void i_should_see_the_price_and_currency_against_Lite_Plan(String price1, String currency1, String plan1) {

		System.out.println(plan1);
		String LitePlan = driver.findElement(By.xpath("//*[@id=\"name-lite\"]")).getText();
		System.out.println(LitePlan);
		
	String LitePrice = driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/b")).getText();
	String LiteCurrency = driver.findElement(By.xpath("//*[@id=\"currency-lite\"]/i")).getText();

	
	assertTrue("Plan is incorrect", LitePlan.contains(plan1));
	assertTrue("Price is incorrect", LitePrice.contains(price1)); //Price contains the expected price1
	assertTrue("Currency is incorrect", LiteCurrency.contains(currency1)); //currency contains the expected currency1
	
		}
		
	@And("I should see the {string} and {string} against {string} Plan B:")
	public void i_should_see_the_price_and_currency_against_Classic_Plan(String price2, String currency2 , String plan2) {

		System.out.println(plan2);
		String ClassicPlan = driver.findElement(By.xpath("//*[@id=\"name-classic\"]")).getText();
		System.out.println(ClassicPlan);
		
	String ClassicPrice = driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/b")).getText();
	String ClassicCurrency = driver.findElement(By.xpath("//*[@id=\"currency-classic\"]/i")).getText();

	
	assertTrue("Plan is incorrect", ClassicPlan.contains(plan2));
	assertTrue("Price is incorrect", ClassicPrice.contains(price2)); //Price contains the expected price1
	assertTrue("Currency is incorrect", ClassicCurrency.contains(currency2)); //currency contains the expected currency1
		}
		
	@And("I should see the {string} and {string} against {string} Plan C:")
	public void i_should_see_the_price_and_currency_against_Premium_Plan(String price3, String currency3, String plan3) {

		String PremiumPlan = driver.findElement(By.xpath("//*[@id=\"name-premium\"]")).getText();

		
	String PremiumPrice = driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/b")).getText();
	String PremiumCurrency = driver.findElement(By.xpath("//*[@id=\"currency-premium\"]/i")).getText();

	
	System.out.println(plan3);
	System.out.println(PremiumPlan);
	
	assertTrue("Plan is incorrect", PremiumPlan.contains(plan3));
	assertTrue("Price is incorrect", PremiumPrice.contains(price3)); //Price contains the expected price1
	assertTrue("Currency is incorrect", PremiumCurrency.contains(currency3)); //currency contains the expected currency1
		}
	
}
