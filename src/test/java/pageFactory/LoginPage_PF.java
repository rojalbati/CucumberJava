package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {
	protected WebDriver driver;
	@FindBy(id = "mat-input-0")
	WebElement txt_email;
	@FindBy(id = "mat-input-1")
	WebElement txt_password;
	@FindBy(xpath = "//*[contains(@class,'btn btn-primary')]")
	WebElement btn_login;
	@FindBy(css = "p.error-message")
	WebElement error_Message;

	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String email) {
		txt_email.sendKeys(email);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogin() {
		btn_login.click();
	}

	public String error_Message() {
		String errorMessage = error_Message.getText();
		return errorMessage;
	}
}
