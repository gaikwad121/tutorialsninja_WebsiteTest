package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.BaseClass;
import com.page.LoginPage;
import com.page.Registore_Page;

public class Reg_Test extends BaseClass {
	Registore_Page reg;

	
	    @BeforeTest
	    public void setUp() throws Exception {
	        initialize(); // Initialize driver and properties
	        reg=new Registore_Page(driver);
	    }

	    @Test
	    public void withValidloginTest() throws InterruptedException {
	    	String First = prop.getProperty("FName").trim();
	        String Lname = prop.getProperty("LName").trim();
	        
	        String emailValue = prop.getProperty("Email").trim();
	        String passwordValue = prop.getProperty("PassWord1").trim();
	        
	        String conf = prop.getProperty("Confpass").trim();
	        String Mob = prop.getProperty("Mobileno").trim();
	        
	        reg.clickMyAccount();
	        Thread.sleep(500);
	        reg.clickregLink();
             reg.FirstName(First);
             reg.sirName(Lname);
             reg.emailId(emailValue);
            reg.password(passwordValue);
             reg.ConfirmPass(conf);
             reg.MobileNo(Mob);
             reg.Agreement();
             reg.Continuebtn();
	        
	    }
	    @AfterTest
	    void TearDown() {
	    	driver.close();
	    }
}
