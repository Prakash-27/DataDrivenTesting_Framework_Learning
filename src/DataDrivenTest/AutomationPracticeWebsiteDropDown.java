package DataDrivenTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticeWebsiteDropDown {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\DataDrivenFramework\\chromedriver.exe"); 
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); 
		  driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account"); 
		  driver.findElement(By.id("email_create")).clear();
		  
		  String sndkys = "prakashs27004@gmail.com";
		  
		  driver.findElement(By.id("email_create")).sendKeys(sndkys);
		  driver.findElement(By.id("SubmitCreate")).click();
		  
		  WebElement day = driver.findElement(By.id("days"));
//		  WebElement months = driver.findElement(By.id("months"));
//		  WebElement years = driver.findElement(By.id("years"));
		  WebElement country = driver.findElement(By.id("id_country"));
		  WebElement state = driver.findElement(By.id("id_state"));
		  
		  Select select = new Select(day); 
		  select.selectByValue("20");
//		
//		  Select select1 = new Select(months); 
//		  select1.selectByIndex(4);
//		
//		  Select select2 = new Select(years); 
//		  select2.selectByValue("2005");
		  
//		  Select select3 = new Select(country);
//		  select3.selectByVisibleText("United States");
//		  
		  Select select4 = new Select(state);
		  select4.selectByVisibleText("California");
		  
//		  SelectValueFromDropDown(day, "9");
//		  SelectValueFromDropDown(months, "June");
//		  SelectValueFromDropDown(years, "1999");
		  
		  
		  
	}

	
	//Genric Method
	
    public static void  SelectValueFromDropDown(WebElement element, String values) {
   	 Select select = new Select(element);
		 select.selectByValue(values);
    }
	
	
	
}
