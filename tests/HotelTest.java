package tests;

import lib.Reporter;
import lib.Util;
import lib.XL;
import pages.HotelPage;
import pages.LoginPage;

public class HotelTest extends BaseTest {

	public HotelTest(String envFile, String browserType,Reporter reporter,XL xl) {
		super(envFile, browserType,reporter, xl);
		
	}

	@Override
	public void runScript() {
		HotelPage hp = new HotelPage(web);
		LoginPage login = new LoginPage(web);
		
		login.login(p.get("email"), p.get("password")); 
		
		hp.nevigateToHotelPage().click();
		reporter.log("Navigate to Hotl Page ");
		hp.selectCity("Kolkata");
		reporter.log("Enter city name : ");
		hp.selecCheckIntDate("15-August-2022");
		Util.hold(2000);
		hp.selecCheckOuttDate("22-August-2022");
			
		hp.travellersBtn().click();
		
		int childAgesInf[] = {10,12}; 
		hp.roomInf(2, 4, childAgesInf);
		
		Util.hold(3000);
		hp.selectNationality("India");
		hp.searchBtn().click();
		
		
	}
	
}
