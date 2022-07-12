package pages;

import org.openqa.selenium.WebElement;

import lib.Web;

public class LoginPage {
	
	public String emailTextXP = "//input[@placeholder='Email']";
	public String passwordXP = "//input[@placeholder='Password']";
	public String loginBtnXP = "//button[.='Login']";
	
	Web web = null;
	public LoginPage(Web web) {
		this.web = web;
	}
	
	public WebElement emailText() {
		return web.getObject(emailTextXP);
	}

	public WebElement passwordText() {
		return web.getObject(passwordXP);
	}
	
	public WebElement loginBtn() {
		return web.getObject(loginBtnXP);
	}
}
