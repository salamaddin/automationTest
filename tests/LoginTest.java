package tests;

import lib.Props;
import lib.Web;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	public LoginTest(String envFile, String browserType) {
		super(envFile, browserType);
		// TODO Auto-generated constructor stub
	}

	public void runScript() {

		String email = p.get("email");
		String password = p.get("password");

		LoginPage login = new LoginPage(web);

		HomePage hm = new HomePage(web);
		hm.nevigateToLoginPage().click();
		hm.gotItBtn().click();

		login.emailText().sendKeys(email);
		login.passwordText().sendKeys(password);
		login.loginBtn().click();

	}

}
