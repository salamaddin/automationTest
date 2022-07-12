import lib.Props;
import tests.BaseTest;
import tests.LoginTest;
import tests.SignUpTest;

public class Engine {

	public static void main(String[] args) {
		String runTest = "SignUpTest";
		
		String envFile = "env.properties";
		Props p = new Props(envFile);
		String browserType = p.get("browserType");

		BaseTest bt = null;
		if (runTest.equals("LoginTest")) {
			bt = new LoginTest(envFile, browserType);
		}
		else if (runTest.equals("SignUpTest")) {
			bt = new SignUpTest(envFile, browserType);
		}
		bt.runScript();

	}

}
