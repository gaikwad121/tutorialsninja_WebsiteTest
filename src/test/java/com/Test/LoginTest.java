package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.BaseClass;
import com.page.LoginPage;

public class LoginTest extends BaseClass {
		    LoginPage loginPage;

		    @BeforeTest
		    public void setUp() throws Exception {
		        initialize(); // Initialize driver and properties
		        loginPage = new LoginPage(driver);
		    }

		    @Test
		    public void withValidloginTest() throws InterruptedException {
		        loginPage.clickMyAccount();
		        Thread.sleep(500);
		        loginPage.clickLoginLink();

		        String emailLocator = prop.getProperty("email").trim();
		        String passwordLocator = prop.getProperty("pass").trim();
		        String loginBtnLocator = prop.getProperty("loginbtn").trim();
		        String emailValue = prop.getProperty("Email").trim();
		        String passwordValue = prop.getProperty("passWord").trim();

		        loginPage.enterEmail(emailLocator, emailValue);
		        loginPage.enterPassword(passwordLocator, passwordValue);
		        loginPage.clickLoginButton(loginBtnLocator);

		        Thread.sleep(1000);
		        Assert.assertTrue(driver.getTitle().contains("My Account"), "Login failed.");
		    }
		    @Test
		    public void withInvalidCredentials() throws InterruptedException {
		    	 loginPage.clickMyAccount();
			        Thread.sleep(500);
			        loginPage.clickLoginLink();

			        String emailLocator = prop.getProperty("email").trim();
			        String passwordLocator = prop.getProperty("pass").trim();
			        String loginBtnLocator = prop.getProperty("loginbtn").trim();
			        String emailValue = prop.getProperty("IncorrectEmail").trim();
			        String passwordValue = prop.getProperty("passWord").trim();

			        loginPage.enterEmail(emailLocator, emailValue);
			        loginPage.enterPassword(passwordLocator, passwordValue);
			        loginPage.clickLoginButton(loginBtnLocator);

			        Thread.sleep(1000);
			        Assert.assertTrue(driver.getTitle().contains("My Account"), "Login failed.");
		    	
		    }

		    @AfterTest
		    public void tearDownTest() {
		        tearDown(); // Quit driver
		    }
		}
