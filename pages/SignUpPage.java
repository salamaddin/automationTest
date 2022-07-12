package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import lib.Web;

public class SignUpPage {
	public String firstNameTextXP = "//input[contains(@name,'first_name')]";
	public String lastNameTextXP = "//input[contains(@name,'last_name')]";
	public String phoneTextXP = "//input[contains(@name,'phone')]";
	public String emailTextXP = "//input[contains(@name,'email')]";
	public String passwordXP = "//input[contains(@name,'password')]";
	public String accountTypeSelectXP = "//select";

	public String toNavigateSignPageXP = "//a[@class='theme-btn theme-btn-small waves-effect']";
	public String signUpBtnXP = "//span[normalize-space()='Signup']";

	Web web = null;

	public SignUpPage(Web web) {
		this.web = web;
	}

	public WebElement navigateToSignUpPage() {
		return web.getObject(toNavigateSignPageXP);
	}

	public WebElement firstNameText() {
		return web.getObject(firstNameTextXP);
	}

	public WebElement lastNameText() {
		return web.getObject(lastNameTextXP);
	}

	public WebElement phoneText() {
		return web.getObject(phoneTextXP);
	}

	public WebElement emailText() {
		return web.getObject(emailTextXP);
	}

	public WebElement passwordText() {
		return web.getObject(passwordXP);
	}

	public void selectAccountType(String accountType) {
		Select se = new Select(web.getObject(accountTypeSelectXP));
		se.selectByVisibleText(accountType);
	}
	
	public WebElement signUpBtn() {
		return web.getObject(signUpBtnXP);
	}
	
	

}
