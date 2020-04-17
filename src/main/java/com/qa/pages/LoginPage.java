package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement LoginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String un, String pass) {
		UserName.sendKeys(un);
		Password.sendKeys(pass);
		
		LoginBtn.click();
		
		return new HomePage();
	}
	
}
