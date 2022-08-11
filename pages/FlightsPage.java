package pages;

import org.openqa.selenium.WebElement;

import lib.Web;

public class FlightsPage extends BasePage {
	
	 public FlightsPage(Web web) {
		super(web);
	}

	String flightsBtnXP = "//a[text()='flights']";
	 String flyingFromXP = "//input[@id='autocomplete']";
	 String flyingFromTopDownXP = "//div[@class='autocomplete-result']";
	 String destinationXP = "//input[@id='autocomplete2']";
	 String destinationTopDownSelectXP = "//div[@class='autocomplete-result']";
	 String searchXP = "//span[text()=' Search']";
	 String calanderXP ="//input[@class='depart form-control']";
	 String nextMonthBtnXP = "(//div[@class='datepicker dropdown-menu' and contains(@style,'display: block;')]//th[@class='next'])[1]";
	
	
	
	public WebElement navigateToFlights() {
		return web.getObject(flightsBtnXP);
	}
	
	public WebElement flyingFromText() {
		return web.getObject(flyingFromXP);
	}
	public WebElement flyingFromTopDown() {
		return web.getObject(flyingFromTopDownXP);
	}
	public WebElement destinationText() {
		return web.getObject(destinationXP);
	}
	public WebElement destinationTopDownSelect() {
		return web.getObject(destinationTopDownSelectXP);
	}
	
	public WebElement calenderBtn() {
		return web.getObject(calanderXP);
	}
	public WebElement nextMonthBtn() {
		return web.getObject(nextMonthBtnXP);
	}
	
	public WebElement searchBtn() {
		return web.getObject(searchXP);
	}
}
