package com.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//@BeforeTest
/*	@Test
	void SetUp() throws IOException {
		//String URL=Files.readString(Path.of("D:\\MyEclipseWorkPlace\\Selenium_Java_Project_01\\src\\test\\resources\\resourses\\URL.txt")).trim();
		String url = Files.readString(Path.of("D:\\MyEclipseWorkPlace\\Selenium_Java_Project_01\\src\\test\\resources\\resources\\URL.txt")).trim();
		System.out.println("Current working directory: " + System.getProperty("user.dir"));

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
	}*/
	    public static WebDriver driver;
	    public static Properties prop;

	    // Load properties and initialize WebDriver
	    public static void initialize() throws IOException {
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

	    public static void loadProperties() throws IOException {
	        if (prop == null) {
	            prop = new Properties();
	            String propPath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "resourses", "Properties.properties").toString();
	            FileInputStream fis = new FileInputStream(propPath);
	            prop.load(fis);
	        }
	    }

	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	

	    }
	
	


