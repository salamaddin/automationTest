package selenium;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	WebDriver driver = null;
	static String randomEmail = "salamaddin";

	public Browser(String driverType) {

		if (driverType.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (driverType.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	public void clickElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void submit(String xpath) {
		driver.findElement(By.xpath(xpath)).submit();
	}

	public void setFirstName(String firstName, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(firstName);
	}

	public void setlastName(String lastName, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(lastName);
	}

	public void setPhoneNumber(String number, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(number);
	}

	public void setEmail(String email, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(email);
	}

	public void setPassword(String password, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(password);
	}

	public void loginClick(String xpath) {
		WebElement login = driver.findElement(By.xpath(xpath));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", login);
	}
	
	public void selectDropdown(String select) {
		List<WebElement> list = driver.findElements(By.xpath("//option"));
		for (WebElement element : list) {
			if(element.getText().equals(select)){
			    element.click();
			}
		}
	}
	
	public void back() {
		driver.navigate().back(); 
	}

	public static String randomEmail() {
		Random random = new Random();
		int randomInt = random.nextInt(10000);
		randomEmail = randomEmail + randomInt + "@gmail.com";

		return randomEmail;
	}
	
	public boolean exists(String xpath) {
		boolean res = false;
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			element.isDisplayed();
			res = true;
			
		}catch(Exception e) {
			
		}
		return res;
	}

	public static void main(String[] args) {

		// default browser chrome
		String driverType = "chrome";

		if (args.length != 0) {
			driverType = args[0];
		}

		Browser browser = new Browser(driverType);
		browser.navigateTo("https://phptravels.net/login");
		//for signup
		browser.clickElement("//a[contains(@class, 'btn btn-outline-primary')]");
		browser.setFirstName("salamaddin", "//input[contains(@name,'first_name')]");
		browser.setlastName("sk", "//input[contains(@name,'last_name')]");
		browser.setPhoneNumber("7031050055", "//input[contains(@name,'phone')]");
		browser.setEmail(randomEmail(), "//input[contains(@name,'email')]");
		browser.setPassword("1234", "//input[contains(@name,'password')]");
		browser.submit("//span[text()='Signup']");
		browser.back();
		//for login
		browser.loginClick("//span[text()='Login']");
		browser.setEmail(randomEmail, "//input[@placeholder='Email']");
		browser.setPassword("1234", "//input[@placeholder='Password']");
		browser.clickElement("//button[.='Login']");
		
		if(browser.exists("//h2[contains(text(),'Hi,')]")) {
			System.out.println("Successfully executed");
		}else {
			System.out.println("Faild");
		}
		

	}

}
