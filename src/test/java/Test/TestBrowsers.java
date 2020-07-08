package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "D:\\Automation Selenium\\Executables Files\\geckodriver.exe");
	    //System.setProperty("webdriver.chrome.driver", "D:\\Automation Selenium\\Executables Files\\chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "D:\\Automation Selenium\\Executables Files\\IEDriverServer.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\Executables Files\\IEDriverServer.exe");
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new  ChromeDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(); 
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
			
		}
					
		//InternetExplorerDriver driver  = new InternetExplorerDriver();
		//ChromeDriver driver  = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
		username.sendKeys("bansalb123");
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("test123");
		WebElement signin = driver.findElement(By.name("login"));
		signin.click();
		
		//WebElement nxtbtn = driver.findElement(By.xpath("//input[@id='login-signin']"));
		
		/* WebElement dropdown = driver.findElement(By.name("country"));
		Select select = new Select(dropdown);
		//select.selectByVisibleText("INDIA");
		select.selectByValue("92");

		*/
		String title = driver.getTitle();
		//System.out.println(title.length());
		System.out.println(title); 
		driver.close();
		//driver.quit();
	}

}
