package lib;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public WebElement explicitlyWaitElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return ele;
	}
	
	public boolean exists(String xpath) {
		boolean res = false;
		try {
			WebElement element = getObject(xpath);
			//element.isDisplayed();
			res = true;
			
		}catch(Exception e) {
			//System.out.println(e);
		}
		return res;
	}
	
	public void screenShot(String fileName) {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(SrcFile, new File("F:\\testing\\src\\main\\java\\ScreenShot\\"+fileName+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void quit() {
		driver.quit();
	}
}
