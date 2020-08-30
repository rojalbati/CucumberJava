package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	protected WebDriver driver;
	private By txt_email = By.id("mat-input-0");
	private By txt_password = By.id("mat-input-1");
	private By btn_login = By.xpath("//*[contains(@class,'btn btn-primary')]");

	public void enterUsername(String email) {
		driver.findElement(txt_email).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(btn_login).click();
	}

	public loginPage(WebDriver driver) {
		this.driver = driver;

	}
}
