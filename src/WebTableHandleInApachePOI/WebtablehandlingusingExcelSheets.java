package WebTableHandleInApachePOI;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class WebtablehandlingusingExcelSheets {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\DataDrivenFramework\\chromedriver.exe"); 
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.get("https://www.w3schools.com/html/html_tables.asp"); 
		  
		 //company_xpath
		  
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		  
		 //contact_xpath
		  
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		//*[@id="customers"]/tbody/tr[4]/td[2]
		  
		//country_xpath
		  
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//*[@id="customers"]/tbody/tr[3]/td[3]
		//*[@id="customers"]/tbody/tr[4]/td[3]  
		  
		  
		String Before_xpathcompany = "//*[@id='customers']/tbody/tr[";
		String After_xpathcompany = "]/td[1]";
		
		String Before_xpathcontact = "//*[@id=\"customers\"]/tbody/tr[";
		String After_xpathcontact = "]/td[2]";  
		  
		String Before_xpathcountry = "//*[@id=\"customers\"]/tbody/tr[";
		String After_xpathcountry = "]/td[3]"; 
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total number of rows are :" + (rows.size()-1));
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Prakash\\eclipse-workspace\\DataDrivenFramework"
				+ "\\src\\com\\testdata\\automationpracticewebsitetestdatas1.xlsx");
		
		if(!(reader.isSheetExist("WebtableData"))) {
			reader.addSheet("WebtableData");
		
		}
		
		reader.addSheet("WebtableData");
		reader.addColumn("WebtableData", "company");
		reader.addColumn("WebtableData", "contact");
		reader.addColumn("WebtableData", "country");
		
		int rowCount = rows.size();
		
		for(int i= 2; i<=7; i++ ) {
			 
			String actual_xpathcompany = Before_xpathcompany+i+After_xpathcompany;
			String Companyname = driver.findElement(By.xpath(actual_xpathcompany)).getText();
			System.out.println(Companyname);
			reader.setCellData("WebtableData", "company", i, Companyname);
			
			String actual_xpathcontact = Before_xpathcontact+i+After_xpathcontact;
			String Contactname = driver.findElement(By.xpath(actual_xpathcontact)).getText();
			System.out.println(Contactname);
			reader.setCellData("WebtableData", "contact", i, Contactname);
			
			String actual_xpathcountry = Before_xpathcountry+i+After_xpathcountry;
			String Countryname = driver.findElement(By.xpath(actual_xpathcountry)).getText();
			System.out.println(Countryname);
			reader.setCellData("WebtableData", "country", i, Countryname);
			
			
			
		}
		  
		  
		  
	}

}
