package DataDrivenTest;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenFrameworkConcept {

	
	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Prakash\\eclipse-workspace\\DataDrivenFramework\\src\\com\\testdata\\AutomationPracticeWebsiteTestdata.xlsx");
		
		String firstname = reader.getCellData("SignIntestdata", "firstname", 2);
		System.out.println(firstname);
		
		String lastname = reader.getCellData("SignIntestdata", "lastname", 2);
		System.out.println(lastname);
		
		String password = reader.getCellData("SignIntestdata", "password", 2);
		System.out.println(password);
		
		String date = reader.getCellData("SignIntestdata", "date", 2);
		System.out.println(date);
		
		String month = reader.getCellData("SignIntestdata", "month", 2);
		System.out.println(month);
		
		String year = reader.getCellData("SignIntestdata", "year", 2);
		System.out.println(year);
		
		String company = reader.getCellData("SignIntestdata", "company", 2);
		System.out.println(company);
		
		String address = reader.getCellData("SignIntestdata", "address", 2);
		System.out.println(address);
		
		String address1 = reader.getCellData("SignIntestdata", "address1", 2);
		System.out.println(address1);
		
		String city = reader.getCellData("SignIntestdata", "city", 2);
		System.out.println(city);
		
		String country = reader.getCellData("SignIntestdata", "country", 2);
		System.out.println(country);
		
		String state = reader.getCellData("SignIntestdata", "state", 2);
		System.out.println(state);
		
		String zipcode = reader.getCellData("SignIntestdata", "zipcode", 2);
		System.out.println(zipcode);
		
		String additionalinfo = reader.getCellData("SignIntestdata", "additionalinfo", 2);
		System.out.println(additionalinfo);
		
		String homenumber = reader.getCellData("SignIntestdata", "homenumber", 2);
		System.out.println(homenumber);
		
		String mobilenumber = reader.getCellData("SignIntestdata", "mobilenumber", 2);
		System.out.println(mobilenumber);
		
		String referenceaddress = reader.getCellData("SignIntestdata", "referenceaddress", 2);
		System.out.println(referenceaddress);
		
		
		//Webdriver
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\DataDrivenFramework\\chromedriver.exe"); 
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); 
		  driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account"); 
		  driver.findElement(By.id("email_create")).clear();
		  driver.findElement(By.id("email_create")).sendKeys("prakashs27004@gmail.com");
		  driver.findElement(By.id("SubmitCreate")).click();
		  
		  
		  List<WebElement> list = driver.findElements(By.name("id_gender"));
		  System.out.println(list.size());
		  
		  for(WebElement e: list) {
		  
		  System.out.println(e.getAttribute("id")); System.out.println(e.isSelected());
		  
		  if(e.getAttribute("id").equals("id_gender1"))
		  { 
			  e.click();
			  }
		  
		  }
		  
		  System.out.println("---------------------------------");
		  
		  for(WebElement e: list) {
		  
		  System.out.println(e.getAttribute("id")); System.out.println(e.isSelected());
		  
		  }
		  
		  driver.findElement(By.name("customer_firstname")).clear();
		  driver.findElement(By.name("customer_firstname")).sendKeys(firstname);
		  
		  driver.findElement(By.name("customer_lastname")).clear();
		  driver.findElement(By.name("customer_lastname")).sendKeys(lastname);
		  
		  driver.findElement(By.name("passwd")).clear();
		  driver.findElement(By.name("passwd")).sendKeys(password);
		  
		  WebElement day = driver.findElement(By.id("days"));
		  WebElement months = driver.findElement(By.id("months"));
		  WebElement years = driver.findElement(By.id("years"));
		  
		  Select select = new Select(day); 
		  select.selectByValue(date);
		
		  Select select1 = new Select(months); 
		  select1.selectByIndex(4);
		
		  Select select2 = new Select(years); 
		  select2.selectByValue(year);
		  
		  List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		  System.out.println(checkboxes.size());
		  
		  for(WebElement e : checkboxes) { 
			  System.out.println(e.getAttribute("name"));
		      System.out.println(e.isSelected());
		  
		  if(e.getAttribute("name").equals("newsletter") ||
		  e.getAttribute("name").equals("optin")) {
		  
		      e.click(); 
		      }
		   }
		  
		  System.out.println("--------------------------------");
		  
		  for(WebElement e : checkboxes) { 
			  System.out.println(e.getAttribute("name"));
		      System.out.println(e.isSelected()); 
		      
		  }
		  
		  
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
		  
		  WebElement countrys = driver.findElement(By.id("id_country"));
		  WebElement states = driver.findElement(By.id("id_state"));
		  
		  Select select3 = new Select(countrys);
		  select3.selectByVisibleText(country);
		  
		  Select select4 = new Select(states);
		  select4.selectByVisibleText(state);
		  
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

}
