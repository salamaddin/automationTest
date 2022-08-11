package tests;

import lib.Reporter;
import lib.XL;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	public LoginTest(String envFile, String browserType,Reporter reporter,XL xl) {
		super(envFile, browserType, reporter, xl);
	}

	public void runScript() {
		System.out.println("login class");
		//String email = p.get("email");
		//	String password = p.get("password");
		
		int row =2;
		String email = xl.getCellData(row,"UserName");
		String password = xl.getCellData(row,"Password");
		
		System.out.println("Login email "+email);
		System.out.println("Login Password "+password);
		


		LoginPage login = new LoginPage(web);

		HomePage hm = new HomePage(web);
		hm.nevigateToLoginPage().click();
		hm.gotItBtn().click();

		login.emailText().sendKeys(email);
		reporter.log("Enter user Name: "+email);
		login.passwordText().sendKeys(password);
		reporter.log("Enter password: "+password);
		login.loginBtn().click();
		reporter.log("Clicked on login Button");
		login.authenticationTest(reporter);
		

	}

}
