package com.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[text()='CRMPRO']")
	WebElement Logo;
	
	@FindBy(xpath="(//a[text()='Upgrade your account'])[2]")
	WebElement UpgradeyourAccount;
	
	@FindBy(id="credit_card_name")
    WebElement CreditCardName;
	
	@FindBy(id="credit_card_number")
    WebElement CreditCardNumber;
	
	@FindBy(name="company_name")
	WebElement CompanyName;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name="postcode")
	WebElement PostCode;
	
	@FindBy(name="country")
	WebElement Country;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement UpgradeAccountBtn;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean logo() {
	boolean flag = Logo.isDisplayed();
	return flag;
	}
	public String title() {
		return driver.getTitle();
		}

	public ContactsPage upgradeYourAccount(String creditcardname, String creditcardnumber, String companyname, String city, String postcode, String country) {
		
		UpgradeyourAccount.click();
		
		Set<String> allwinhan = driver.getWindowHandles();
	    List<String> li= new ArrayList<String>();
	    
	    li.addAll(allwinhan);
	    String homepage = li.get(0);
	    String page = li.get(1);
		
		driver.switchTo().window(page);
		
		CreditCardName.sendKeys(creditcardname);
		CreditCardNumber.sendKeys(creditcardnumber);
        CompanyName.sendKeys(companyname);
        City.sendKeys(city);
        PostCode.sendKeys(postcode);
        Country.sendKeys(country);
        UpgradeAccountBtn.click();
        driver.close();
        
       driver.switchTo().window(homepage);
        
        return new ContactsPage();
	}
}
