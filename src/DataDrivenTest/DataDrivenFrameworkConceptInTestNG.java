package DataDrivenTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class DataDrivenFrameworkConceptInTestNG {
	
	static WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\DataDrivenFramework\\chromedriver.exe"); 
		  driver = new ChromeDriver();
		  driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); 
		  driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account"); 
		  driver.findElement(By.id("email_create")).clear();
		  driver.findElement(By.id("email_create")).sendKeys("prakashs27004@gmail.com");
		  driver.findElement(By.id("SubmitCreate")).click();
	}
	
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
		
		 return testdata.iterator();
	}
	
	
	
	@Test(dataProvider = "getTestData", priority = 1)
	public void AutomationPracticeSignInTest(String firstname, String lastname, String password, String company, 
			String address, String address1, String city, String zipcode, String additionalinfo, String homenumber, 
			String mobilenumber, String referenceaddress ) {
		
		 driver.findElement(By.name("customer_firstname")).clear();
		  driver.findElement(By.name("customer_firstname")).sendKeys(firstname);
		  
		  driver.findElement(By.name("customer_lastname")).clear();
		  driver.findElement(By.name("customer_lastname")).sendKeys(lastname);
		  
		  driver.findElement(By.name("passwd")).clear();
		  driver.findElement(By.name("passwd")).sendKeys(password);
		   
		  driver.findElement(By.name("firstname")).clear();
		  driver.findElement(By.name("firstname")).sendKeys(firstname);
		  
		  driver.findElement(By.name("lastname")).clear();
		  driver.findElement(By.name("lastname")).sendKeys(lastname);
		  
		  driver.findElement(By.name("company")).clear();
		  driver.findElement(By.name("company")).sendKeys(company);
		  
		  driver.findElement(By.name("address1")).clear();
		  driver.findElement(By.name("address1")).sendKeys(address);
		  
		  driver.findElement(By.name("address2")).clear();
		  driver.findElement(By.name("address2")).sendKeys(address1);
		  
		  driver.findElement(By.name("city")).clear();
		  driver.findElement(By.name("city")).sendKeys(city);
		  
		  driver.findElement(By.name("postcode")).clear();
		  driver.findElement(By.name("postcode")).sendKeys(zipcode);
		  
		  driver.findElement(By.name("other")).clear();
		  driver.findElement(By.name("other")).sendKeys(additionalinfo);
		  
		  driver.findElement(By.name("phone")).clear();
		  driver.findElement(By.name("phone")).sendKeys(homenumber);
		  
		  driver.findElement(By.name("phone_mobile")).clear();
		  driver.findElement(By.name("phone_mobile")).sendKeys(mobilenumber);
		  
		  driver.findElement(By.name("alias")).clear();
		  driver.findElement(By.name("alias")).sendKeys(referenceaddress);
		  
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		 
		driver.quit();
	}
	
	

}
