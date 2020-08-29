package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GooglSearchSteps {
	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/test/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {

		// System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");

	}

	@When("^user enters a (.*) in search box$")
	public void user_enters_a_text_in_search_box(String text) {
		driver.findElement(By.name("q")).sendKeys(text);
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	}

	@Then("^user is navigated to search results page (.*)$")
	public void user_is_navigated_to_search_results_page(String text) {
		//System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains(text));

		driver.close();
	}

}
