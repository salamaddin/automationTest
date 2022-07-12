package tests;

import lib.Props;
import lib.Web;

public abstract class BaseTest {
	String envFile, browserType;
	Web web;
	String env, url;
	Props p;
	
	public BaseTest(String envFile, String browserType) {
		web = new Web(browserType);
		p = new Props(envFile);
		env = p.get("env");
		url = p.get(env+"_env_url");
		web.launchUrl(url);
		
	}
	
	public abstract void runScript();
	
}
