package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import lib.Reporter;
import lib.Web;

public class LoginPage extends BasePage {
	
	public LoginPage(Web web) {
		super(web);
	}

	public String emailTextXP = "//input[@placeholder='Email']";
	public String passwordXP = "//input[@placeholder='Password']";
	public String loginBtnXP = "//button[.='Login']";
	public String authenticationXP ="//h2[contains(text(),'Hi,')]";
	
	
	public WebElement emailText() {
		return web.getObject(emailTextXP);
	}

	public WebElement passwordText() {
		return web.getObject(passwordXP);
	}
	
	public WebElement loginBtn() {
		return web.getObject(loginBtnXP);
	}
	
	public void login(String email, String password) {
		
		HomePage hm = new HomePage(web);
		hm.nevigateToLoginPage().click();
		hm.gotItBtn().click();
		
		emailText().sendKeys(email);
		passwordText().sendKeys(password);
		loginBtn().click();
	}
	
	
	public void authenticationTest(Reporter reporter) {
		if (web.exists(authenticationXP)) {
			reporter.pass("Successfuly logged in");
		} else {
			reporter.fail("Login failed");
		}
	}
}
