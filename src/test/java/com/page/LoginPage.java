package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	    WebDriver driver;

	    // Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Static locators
	    By myAccount = By.xpath("//span[.='My Account']");
	    By loginLink = By.xpath("//a[.='Login']");
     
	    public void clickMyAccount() {
	        driver.findElement(myAccount).click();
	    }

	    public void clickLoginLink() {
	        driver.findElement(loginLink).click();
	    }

	    public void enterEmail(String emailXpath, String emailValue) {
	        driver.findElement(By.xpath(emailXpath)).sendKeys(emailValue);
	    }

	    public void enterPassword(String passwordCss, String passwordValue) {
	        driver.findElement(By.cssSelector(passwordCss)).sendKeys(passwordValue);
	    }

	    public void clickLoginButton(String loginBtnCss) {
	        driver.findElement(By.cssSelector(loginBtnCss)).click();
	    }
	    public void IncorrectEmail(String emailXpath, String emailValue) {
	        driver.findElement(By.xpath(emailXpath)).sendKeys(emailValue);
	    }

	    public void correctPassword(String passwordCss, String passwordValue) {
	        driver.findElement(By.cssSelector(passwordCss)).sendKeys(passwordValue);
	    }
	}
