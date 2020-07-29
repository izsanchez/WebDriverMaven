package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
	}

	@Test
	public void doLogin() throws InterruptedException {
		
		driver.get("http://gmail.com");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.linkText("Acceder")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("identifierId")).sendKeys("izsanchez@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
}
