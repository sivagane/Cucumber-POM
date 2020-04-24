package com.qa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class DealsPage extends TestBase {

	@FindBy(xpath="//a[text()='Deals']")
	WebElement Deals;
	
	@FindBy(xpath="//a[text()='New Deal']")
	WebElement NewDeal;
	
	@FindBy(id="title")
	WebElement Title;
	
	@FindBy(xpath="//input[@type='text' and @name='contact_lookup']/following-sibling::input")
	WebElement ContactLookup;
	
	@FindBy(id="search")
	WebElement ContactSearch;
	
	@FindBy(xpath="//input[@id='search']//following-sibling::input")
	WebElement ContactSearchBtn;
	
	@FindBy(xpath="(//a[text()='siva ganesh'])[1]")
	WebElement Contact;
	
	@FindBy(xpath="//img[@id='f_trigger_c_close_date']")
	WebElement PredictedCloseCalender;
	
	@FindBy(xpath="(//tr[@class='daysrow']//td[text()='27'])[2]")
	WebElement PredictedCloseDate;
	
	@FindBy(id="f_trigger_c_actual_close_date")
	WebElement ActualCloseCalender;
	
	@FindBy(xpath="(//tr[@class='daysrow']//td[text()='30'])[3]")
	WebElement ActualCloseDate;
	
	@FindBy(xpath="//td[@align='center' and @valign='top' and @colspan='2']/descendant::input[@value='Save']")
	WebElement Save;
	
	@FindBy(xpath="//input[@type='button' and @value='X']")
	WebElement ContactLookupPopupClose;
	
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String title() {
		return driver.getTitle();
	}
	
	public TasksPage enterDealsDetails(String dealtitle, String contactname) throws InterruptedException {
		Actions action= new Actions(driver);
		action.moveToElement(Deals).build().perform();
		NewDeal.click();
		Title.sendKeys(dealtitle);
		ContactLookup.click();
		Set<String> allwinhan = driver.getWindowHandles();
		List<String>li= new ArrayList<String>();
		li.addAll(allwinhan);
		String parhan = li.get(0);
		String chihan = li.get(1);
//		Iterator<String> itr = allwinhan.iterator();
//		String parentwinhan = itr.next();
		
		
//		String childwinhan = itr.next();
       	driver.switchTo().window(chihan);
		
		ContactSearch.sendKeys(contactname);
		ContactSearchBtn.click();
		
		Contact.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("1000");
		
		
		PredictedCloseCalender.click();
		PredictedCloseDate.click();
		ActualCloseCalender.click();
		ActualCloseDate.click();
		Save.click();
		
		return new TasksPage();
		
	}
	
}
