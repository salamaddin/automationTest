package tests;

import lib.Props;
import lib.Util;
import lib.Web;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

	public SignUpTest(String envFile, String browserType) {
		super(envFile, browserType);
	}
//	public static void main(String[] args) throws InterruptedException {
//		String driverType = "chrome";
//		
//		if (args.length != 0) {
//			driverType = args[0];
//		}

	@Override
	public void runScript() {
		SignUpPage signUp = new SignUpPage(web);
		
		Util util = new Util();
		String email = util.randomString() + "@gmail.com";
		
		p.updateProperties("email", email);
		System.out.println(p.get("email"));
		
		HomePage hm = new HomePage(web);
		hm.nevigateToLoginPage().click();
		hm.gotItBtn().click();
		
		signUp.navigateToSignUpPage().click();
		signUp.firstNameText().sendKeys("salam");
		signUp.lastNameText().sendKeys("sk");
		signUp.phoneText().sendKeys("7031050055");
		signUp.emailText().sendKeys(email);
		signUp.passwordText().sendKeys("1234");
		signUp.selectAccountType("Agent");
		signUp.signUpBtn().submit();
		
	}
}
		
//		Props p = new Props("env.properties");
//		System.out.println(p.get("qa_env_url"));
//		System.out.println(p.get("email"));
		
//		Web web = new Web(driverType);
//		web.maximizeWindow();
//		Thread.sleep(3000);
//		web.launchUrl("https://phptravels.net/login");
		
		
		
//		Thread.sleep(3000);
		
//		SignUpPage signUp = new SignUpPage(web);
//		LoginPage login = new LoginPage(web);
//		
//		Util util = new Util();
//		String email = util.randomString() + "@gmail.com";
//		
//		p.updateProperties("email", email);
//		System.out.println(p.get("email"));
////		
//		signUp.navigateToSignUpPage().click();
//		signUp.firstNameText().sendKeys("salam");
//		signUp.lastNameText().sendKeys("sk");
//		signUp.phoneText().sendKeys("7031050055");
//		signUp.emailText().sendKeys(email);
//		signUp.passwordText().sendKeys("1234");
//		signUp.selectAccountType("Agent");
//		signUp.signUpBtn().submit();
//		
//		login.emailText().sendKeys(email);
//		login.passwordText().sendKeys("1234");
//		login.loginBtn().click();
		
//}
