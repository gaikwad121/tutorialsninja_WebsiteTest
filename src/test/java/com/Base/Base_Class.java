package com.Base;

	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Base_Class {
		 WebDriver driver = null;
		 @Test
		 public void LaunchBrowser(String browserName) throws InterruptedException, IOException {
		       this.driver=new ChromeDriver();

		        switch (browserName.toLowerCase()) {
		            case "chrome":
		                WebDriverManager.chromedriver().setup();
		                driver = new ChromeDriver();
		                break;
		            case "edge":
		                WebDriverManager.edgedriver().setup();
		                driver = new EdgeDriver();
		                break;
		            case "firefox":
		                WebDriverManager.firefoxdriver().setup();
		                driver = new FirefoxDriver();
		                break;
		            default:
		                System.out.println("Invalid browser: " + browserName);
		        }
		      
		    
		  
		   // public void launchUrlFromFile() throws IOException, InterruptedException {
		        // Step 1: Load the properties file
		        String propPath = Paths.get(System.getProperty("user.dir"), "src\\test\\resources\\resourses\\Properties.properties").toString();
		     
		        FileInputStream fis = new FileInputStream(propPath);
		      

		        Properties prop = new Properties();
		        prop.load(fis);
		       
		        // Step 2: Get URL
		        String Browser=prop.getProperty("browser").trim();
		        String url = prop.getProperty("url").trim();
		        System.out.println("Launching: " + url);
          String email=prop.getProperty("email").trim();
          String pass=prop.getProperty("pass").trim();
          String loginBtn=prop.getProperty("loginbtn").trim();
          String Email_Id=prop.getProperty("Email").trim();
          String Pass=prop.getProperty("passWord").trim();
		        // Step 3: Launch browser and open URL
		     //   WebDriver driver = LaunchBrowser(Browser);
          driver.get(url);
		        if (driver != null) {
		            driver.get(url);
		            driver.manage().window().maximize();
		            
		            Thread.sleep(500);
		            driver.findElement(By.xpath("//span[.='My Account']")).click();
		        	try {
		        		Thread.sleep(500);
		        	} catch (InterruptedException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        	}
		        	// Login with Valid  credentials
		        	driver.findElement(By.xpath("//a[.='Login']")).click();
		        	driver.findElement(By.xpath(email)).sendKeys(Email_Id);
		         driver.findElement(By.cssSelector(pass)).sendKeys(Pass);
		         driver.findElement(By.cssSelector(loginBtn)).click();
		         String actual="My Account";
		         String Expected=driver.getTitle();
		     Assert.assertEquals(actual, Expected);
		        
		    }
		        
		  }
		  @AfterTest
		  void TearDown() {
			  driver.close();
		  }
		}
	
	
	
	
	
	
