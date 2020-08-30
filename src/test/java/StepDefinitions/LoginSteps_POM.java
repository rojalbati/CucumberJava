package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.loginPage;

public class LoginSteps_POM {
	WebDriver driver = null;
	loginPage login;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "./src/test/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.navigate().to("https://oho.bajratechnologies.com/auth/sign-in");
		Assert.assertEquals(driver.getCurrentUrl(), "https://oho.bajratechnologies.com/auth/sign-in");
	}

	@When("^user enter (.*) and (.*)$")
	public void user_enter_email_and_password(String email, String password) {
		// driver.findElement(By.id("mat-input-0")).sendKeys(email);
		// driver.findElement(By.id("mat-input-1")).sendKeys(password);
		login = new loginPage(driver);
		login.enterUsername(email);
		login.enterPassword(password);

	}

	@And("click login button")
	public void click_login_button() {
		// driver.findElement(By.xpath("//*[contains(@class,'btn
		// btn-primary')]")).click();
		login.clickLogin();

	}

	@Then("user is redirected to Landingpage")
	public void user_is_redirected_to_landingpage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(driver.getCurrentUrl());
		// Assert.assertEquals(driver.getCurrentUrl(),
		// "https://oho.bajratechnologies.com/");

	}

	@And("user is notified of successfull login")
	public void user_is_notified_of_successfull_login() {
		// System.out.println(driver.findElement(By.cssSelector("div.ant-notification-notice-description")).getText());
		// Assert.assertTrue(driver.findElement(By.cssSelector("div.ant-notification-notice-description")).getText()
		// .contains("You have successfully logged in to your account."));

		driver.close();
	}

	@Then("error message is shown")
	public void error_message_is_shown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://oho.bajratechnologies.com/auth/sign-in");
		// System.out.println(driver.findElement(By.cssSelector("p.error-message")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("p.error-message")).getText(), "Invalid credentials");

		driver.close();
	}

	@Then("validation error message is shown")
	public void validation_error_message_is_shown() {
		// System.out.println(driver.findElement(By.cssSelector("mat-error#mat-error-0")).getText());
		Assert.assertEquals(driver.getCurrentUrl(), "https://oho.bajratechnologies.com/auth/sign-in");
		// System.out.println(driver.findElement(By.cssSelector("mat-error#mat-error-1>span")).getText());
		Assert.assertTrue(
				driver.findElement(By.cssSelector("mat-error#mat-error-0")).getText().contains("Email is required."));
		Assert.assertTrue(driver.findElement(By.cssSelector("mat-error#mat-error-1>span")).getText()
				.contains("Password is required."));

		driver.close();
	}
}
