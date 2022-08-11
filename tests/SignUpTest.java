package tests;

import lib.Reporter;
import lib.Util;
import lib.XL;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

	public SignUpTest(String envFile, String browserType,Reporter reporter,XL xl) {
		super(envFile, browserType,reporter,xl);
	}

	@Override
	public void runScript() {
		
		Util util = new Util();
		//String email = util.randomString(10) + "@gmail.com";
		//String password = p.get("password");
		//p.set("email",email);
		
		int row = 2;
		String firstName = xl.getCellData(row,"FirstName");
		String lastName = xl.getCellData(row,"LastName");
		String mobileNum = xl.getCellData(row,"Phone");
		String email = xl.getCellData(row,"Email");
		String password = xl.getCellData(row,"Password");
		String accountType = xl.getCellData(row, "AccountType");
		
		//String email2 = xl.getCellData(1,3);
		//System.out.println("SignUp Email "+email +"passsword :" +password);
		//String firstName = p.get("firstName");
		//String lastName = p.get("lastName");
		//String mobileNum=p.get("mobileNum");
		//String accountType =p.get("accountType");
		
		HomePage hm = new HomePage(web);
		hm.nevigateToLoginPage().click();
		hm.gotItBtn().click();
		
		SignUpPage signUp = new SignUpPage(web);
		
		signUp.navigateToSignUpPage().click();
		signUp.firstNameText().sendKeys(firstName);
		reporter.log("Enter first Name : "+firstName);
		signUp.lastNameText().sendKeys(lastName);
		reporter.log("Enter Last Name : "+lastName);
		signUp.phoneText().sendKeys(mobileNum);
		reporter.log("Enter Mobile Number : "+mobileNum);
		signUp.emailText().sendKeys(email);
		reporter.log("Enter Email : "+email);
		signUp.passwordText().sendKeys(password);
		reporter.log("Enter password: "+password);
		signUp.selectAccountType(accountType);
		reporter.log("Account type : "+accountType);
		signUp.signUpBtn().submit();
		reporter.log("Clicked on signUp button");
		signUp.authenticationTest(reporter);
		
	}
}



