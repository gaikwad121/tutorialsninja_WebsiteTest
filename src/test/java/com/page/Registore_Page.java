package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registore_Page  {
	
	WebDriver driver;
	
	public Registore_Page(WebDriver driver) {
		this.driver=driver;
	}
	By regBtn=By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[.='Register']");
	By myAccount = By.xpath("//span[.='My Account']");
	By First=By.xpath("//input[@name=\"firstname\"]");
	By Sirname=By.xpath("//input[@name=\"lastname\"]");
	By Email_ID=By.xpath("//input[@name=\"email\"]");
	By Mob=By.xpath("//input[@name=\"telephone\"]");
	By pass=By.xpath("//input[@name=\"password\"]");
	By confPass=By.xpath("//input[@name=\"confirm\"]");
	By Agree=By.xpath("//input[@name=\"agree\"]");
	By Continue=By.xpath("//input[@value=\"Continue\"]");
	//ul[@class="dropdown-menu dropdown-menu-right"]//a[.='Register']
	 public void clickMyAccount() {
	        driver.findElement(myAccount).click();
	    }

	    public void clickregLink() {
	        driver.findElement(regBtn).click();
	    }
	    public void FirstName(String FName) {
	        driver.findElement(First).sendKeys(FName);
	    }
	    public void sirName(String LName) {
	        driver.findElement(Sirname).sendKeys(LName);
	    }
	    public void emailId(String Email) {
	        driver.findElement(Email_ID).sendKeys(Email);
	    }
	    public void MobileNo(String Mobileno) {
	        driver.findElement(Mob).sendKeys(Mobileno);
	    }
	    public void password(String PassWord1) {
	        driver.findElement(pass).sendKeys(PassWord1);
	    }
	    public void ConfirmPass(String Confpass) {
	        driver.findElement(confPass).sendKeys(Confpass);
	    }
	    public void Agreement() {
	        driver.findElement(Agree).click();
	    }
	    public void Continuebtn() {
	        driver.findElement(Continue).click();
	    }

}
