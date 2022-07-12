import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	public static void main(String[] args) {
		//uses chrome driver jar file	
		System.setProperty("webdriver.chrome.driver","C://Users//Salamaddin//Downloads//chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/"); 
	}

}
