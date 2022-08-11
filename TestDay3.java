import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDay3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://phptravels.net/login");
		
		WebElement signup = driver.findElement(By.xpath("//a[contains(@class, 'btn btn-outline-primary')]"));
		signup.click();
		
		WebElement fistName = driver.findElement(By.xpath("//input[contains(@name,'first_name')]"));
		WebElement lastName = driver.findElement(By.xpath("//input[contains(@name,'last_name')]"));
		WebElement phone = driver.findElement(By.xpath("//input[contains(@name,'phone')]"));
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		WebElement password = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		WebElement submit = driver.findElement(By.xpath("//span[text()='Signup']"));
	
		fistName.sendKeys("salam");
		lastName.sendKeys("sk");
		phone.sendKeys("7031050055");
		email.sendKeys("salamaddinsk103@gmail.com");
		password.sendKeys("sk@123456");
		//submit.submit();
		
	}

}
