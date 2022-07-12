import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// search product on amazon
//		driver.get("https://www.amazon.in/");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("i phone");
//		driver.findElement(By.id("nav-search-submit-button")).click();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("java tutorial");
		Thread.sleep(4000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
		
		System.out.println("size"+elements.size());
		for (WebElement element : elements) {
		    System.out.println("Paragraph text:" + element.getText());
		}
	}

}
