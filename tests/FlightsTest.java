package tests;

import lib.Reporter;
import lib.XL;
import pages.FlightsPage;

public class FlightsTest extends BaseTest {
	
	String month = "August 2022";
	String day = "22";

	public FlightsTest(String envFile, String browserType, Reporter reporter, XL xl) {
		super(envFile, browserType,reporter,xl);
	}

	@Override
	public void runScript() {
		FlightsPage flight = new FlightsPage(web);
		
		flight.navigateToFlights().click();
		flight.flyingFromText().sendKeys("kolkata");
		flight.flyingFromTopDown().click();
		
		flight.destinationText().sendKeys("bagdogra");
		flight.destinationTopDownSelect().click();
		flight.calenderBtn().click();
		flight.nextMonthBtn().click();
		
		
		
	//	flight.searchBtn().click();

		
	}

}
