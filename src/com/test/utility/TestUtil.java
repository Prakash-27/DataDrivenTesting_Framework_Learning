package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel()  {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
		    reader = new Xls_Reader("C:\\Users\\Prakash\\eclipse-workspace\\DataDrivenFramework\\src\\com\\testdata\\automationpracticewebsitetestdatas1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		reader.addColumn("SigninInputFieldData", "Status");
		
		for(int rowNum = 2; rowNum <= reader.getRowCount("SigninInputFieldData"); rowNum++ ) {
			
		  String firstname = reader.getCellData("SigninInputFieldData", "firstname", rowNum);
		  String lastname = reader.getCellData("SigninInputFieldData", "lastname", rowNum);
     	  String password = reader.getCellData("SigninInputFieldData", "password", rowNum);
     	  String company = reader.getCellData("SigninInputFieldData", "company", rowNum);
     	  String address = reader.getCellData("SigninInputFieldData", "address", rowNum);
     	  String address1 = reader.getCellData("SigninInputFieldData", "address1", rowNum);
     	  String city = reader.getCellData("SigninInputFieldData", "city", rowNum);
     	  String zipcode = reader.getCellData("SigninInputFieldData", "zipcode", rowNum);
     	  String additionalinfo = reader.getCellData("SigninInputFieldData", "additionalinfo", rowNum);
     	  String homenumber = reader.getCellData("SigninInputFieldData", "homenumber", rowNum);
     	  String mobilenumber = reader.getCellData("SigninInputFieldData", "mobilenumber", rowNum);
     	  String referenceaddress = reader.getCellData("SigninInputFieldData", "referenceaddress", rowNum);
     	  
     	  Object ob[] = {firstname, lastname, password, company, address, address1, 
     			  city, zipcode, additionalinfo, homenumber, mobilenumber, referenceaddress};
     	  
     	  myData.add(ob);
         
     	  reader.setCellData("SigninInputFieldData", "Status", rowNum, "Pass");
		}
		
		return myData;
	
	}
}
