package com.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	
	    public static WebDriver driver;
	    public static Properties prop;

	    // Load properties and initialize WebDriver
	    public void initialize() throws IOException {
	        loadProperties();

	        String browserName = prop.getProperty("browser").trim();

	        switch (browserName.toLowerCase()) {
	            case "chrome":
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                break;
	            case "edge":
	                WebDriverManager.edgedriver().setup();
	                driver = new EdgeDriver();
	                break;
	            default:
	                throw new IllegalArgumentException("Unsupported browser: " + browserName);
	        }

	        driver.manage().window().maximize();
	        driver.get(prop.getProperty("url").trim());
	    }

	    // Load configuration from properties file
	    public void loadProperties() throws IOException {
	        if (prop == null) {
	            prop = new Properties();
	            String propPath = Paths.get(System.getProperty("user.dir"), "src\\test\\resources\\resourses\\Properties.properties").toString();
			     
	            FileInputStream fis = new FileInputStream(propPath);
	            prop.load(fis);
	        }
	    }

	    // Teardown method
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

