import java.lang.reflect.Constructor;

import lib.Props;
import lib.Reporter;
import lib.Util;
import lib.XL;
import tests.BaseTest;
import tests.LoginTest;

public class Engine {

	public static void main(String[] args) {

		String envFile = "env.properties";
		Props p = new Props(envFile);
		String browserType = p.get("browserType");
		String runTest = "SignUpTest";
		Reporter reporter = new Reporter("F:\\SeleniumTest\\reports\\ExcutionResult.html");
		BaseTest bt = null;

		// bt = new LoginTest(envFile, browserType,reporter, null);
//		if (runTest.equals("LoginTest")) {
//			bt = new LoginTest(envFile, browserType,reporter);
//		}
//		else if (runTest.equals("SignUpTest")) {
//			bt = new SignUpTest(envFile, browserType,reporter);
//		}
//		else if (runTest.equals("FlightsTest")) {
//			bt = new FlightsTest(envFile, browserType,reporter);
//		}
//		else if (runTest.equals("HotelTest")) {
//			bt = new HotelTest(envFile, browserType,reporter);
//		}
//		
//		bt.initTest();
//		bt.runScript();
//		bt.endTest();
		
		Util util = new Util();
		String path = util.getResourcePath("ScriptsList.xlsx");
		XL xlScript = new XL(path);
		xlScript.openSheet("Scripts");
		int rowCount = xlScript.getSheetRowCount();
		XL xl = null;

		for (int i = 1; i < rowCount; i++) {
			String excute = xlScript.getCellData(i, 3);
			String testClass = xlScript.getCellData(i, "ScriptCode");

			if (excute.equals("Y")) {

				try {

					String testDataFileName = xlScript.getCellData(i, "TestDataFileName");
					System.out.println("test Data File NAme: " + testDataFileName);
					String testDataPath = util.getResourcePath("test-data/" + testDataFileName + ".xlsx");

					xl = new XL(testDataPath);
					String firstSheet = xl.getFirstSheet();
					System.out.println(" Sheet Name " + firstSheet);
					xl.openSheet(firstSheet);
					//Reflection api
					Class<?> cls = Class.forName("tests." + testClass);
					Constructor<?> con = cls.getConstructor(String.class, String.class, Reporter.class, XL.class);
					bt = (BaseTest) con.newInstance(new Object[] { envFile, browserType, reporter, xl });

					bt.initTest();
					bt.runScript();
					bt.endTest();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.print(" test class name " + testClass + " ");
			System.out.println(excute);

		}
		xlScript.close();

	}

}
