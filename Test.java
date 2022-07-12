import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		
	WebDriver driver = null;
	//String driverType = args[0];
	String driverType = "chrome";
	
	if(driverType.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	else if(driverType.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	driver.get("https://phptravels.net/login");
	

	WebElement signup = driver.findElement(By.xpath("//a[contains(@class, 'btn btn-outline-primary')]"));
	signup.click();
	//driver.quit();
	
	WebElement fistName = driver.findElement(By.xpath("//input[contains(@name,'first_name')]"));
	WebElement lastName = driver.findElement(By.xpath("//input[contains(@name,'last_name')]"));
	WebElement phone = driver.findElement(By.xpath("//input[contains(@name,'phone')]"));
	WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
	WebElement password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
	WebElement submit = driver.findElement(By.xpath("//span[text()='Signup']"));
	WebElement login = driver.findElement(By.xpath("//span[text()='Login']"));
	
//	Thread.sleep(4000);
	List<WebElement> list = driver.findElements(By.xpath("//option"));
//	Thread.sleep(4000);
	

//	Select select = new Select(dropDown);
//	WebElement firstOption = select.getFirstSelectedOption();
	System.out.println("size"+list.size());
	for (WebElement element : list) {
	    System.out.println("Paragraph text:" + element.getText());
	}
	
//	WebElement dropdown = driver.findElement(By.xpath("//option[@value='agent']"));
//	dropdown.click();
	//System.out.println(dropdown.getText());
	
	fistName.sendKeys("salam");
	lastName.sendKeys("sk");
	phone.sendKeys("7031050055");
	email.sendKeys("salamaddinsk103@gmail.com");
	password.sendKeys("sk@123456");
	//submit.submit();
	Thread.sleep(4000);
	//login.click();
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()", login);
	
	}

}