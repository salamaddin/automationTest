package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web {
	WebDriver driver = null;

	public Web(String browserType) {
		if (browserType.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserType.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

	}
	
	public void launchUrl(String url) {
		driver.get(url);
	}
	
	public WebElement getObject(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void quit() {
		driver.quit();
	}
}
