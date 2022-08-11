package tests;

import lib.Props;
import lib.Reporter;
import lib.Web;
import lib.XL;

public abstract class BaseTest {
	String envFile, browserType;
	Web web;
	String env, url;
	Props p;
	Reporter reporter;
	XL xl;
	
	public BaseTest(String envFile, String browserType, Reporter reporter, XL xl) {
	
		this.reporter = reporter;
		this.browserType = browserType;
		this.xl =xl;
		p = new Props(envFile);
		env = p.get("env");
		url = p.get(env+"_env_url");
		
	}
	
	public void initTest() {
		String testName = this.getClass().getName();
		reporter.startTest(testName);
		web = new Web(browserType);
		web.maximizeWindow();
		web.launchUrl(url);
	}
	
	public abstract void runScript();
	
	public void endTest() {
		reporter.endTest();
	}
	
}
