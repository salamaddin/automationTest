package selenium;

import java.sql.DriverManager;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TutorFinderTest {

	WebDriver driver = null;
	static String randomEmail = "salamaddin";

	public TutorFinderTest(String browserType) {
		if (browserType.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserType.equals("edge")) {
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
			if (element.getText().equals(select)) {
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

	public static void main(String[] args) {

		String browserType = "chrome";
		if (args.length != 0) {
			browserType = args[0];
		}
		
		TutorFinderTest test = new TutorFinderTest(browserType);
		test.navigateTo("https://tutorfinderwebapp.herokuapp.com/");
		test.clickElement("//a[normalize-space()='Signup']");
	}

}
