package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.util.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement Contacts;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement NewContacts;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='department']")
	WebElement Department;
	
	@FindBy(xpath="//input[@id='image_file']")
	WebElement Image;
	
	@FindBy(xpath="//select[@class='select' and @name='category']")
	WebElement Category;
	
	@FindBy(xpath="//input[@name='allows_call' and @value='N']")
	WebElement AllowCallRadioNo;
	
	@FindBy(xpath="//input[@type='button' and @value='Load From Company']/following-sibling::input[@value='Save']")
	WebElement Save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public DealsPage enterContactDetails(String fn, String ln, String dept) {
		Actions action= new Actions(driver);
		action.moveToElement(Contacts).perform();
		NewContacts.click();
		FirstName.sendKeys(fn);
		LastName.sendKeys(ln);
		Image.sendKeys("C:\\Users\\sivag\\Downloads\\Siva.xlsx");
		Department.sendKeys(dept);
		Select s= new Select(Category);
		s.selectByVisibleText("Lead");
		AllowCallRadioNo.click();
		Save.click();
		
		return new DealsPage();
		}
	}
