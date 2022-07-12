package pages;

import org.openqa.selenium.WebElement;

import lib.Web;

public class HomePage {
	public String neviagetToLoginXp= "//a[@class='theme-btn theme-btn-small theme-btn-transparent ml-1 waves-effect']";
	public String gotItBtnXp = "//button[@id='cookie_stop']";
	
	Web web = null;
	public HomePage(Web web) {
		this.web = web;
	}
	
	public WebElement nevigateToLoginPage() {
		return web.getObject(neviagetToLoginXp);
	}
	
	public WebElement gotItBtn() {
		return web.getObject(gotItBtnXp);
	}
}
