package com.qa.StepDefinition;

import org.junit.Assert;

import com.qa.pages.ContactsPage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.TasksPage;
import com.qa.util.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends TestBase {
	TestBase testbase;
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;

	@Given("User Login to the FreeCRM Application")
	public void user_Login_to_the_FreeCRM_Application() throws InterruptedException {
		TestBase.initialization();
		loginpage = new LoginPage();

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
	}

	@Then("User enters the hompage checks the title and logo")
	public void user_enters_the_hompage_checks_the_title_and_logo() {
		driver.switchTo().frame("mainpanel");

		boolean logo = homepage.logo();
		Assert.assertTrue(logo);

		String title = homepage.title();
		Assert.assertEquals("CRMPRO", title);

		contactspage = homepage.upgradeYourAccount(prop.getProperty("creditcardname"),
				prop.getProperty("creditcardnumber"), prop.getProperty("companyname"), prop.getProperty("city"),
				prop.getProperty("postcode"), prop.getProperty("country"));
	}

	@Then("User enters the new Contacts page verify title and enters the contact details")
	public void user_enters_the_new_Contacts_page_verify_title_and_enters_the_contact_details() {
        String contactpagetitle = contactspage.title();
		Assert.assertEquals("CRMPRO", contactpagetitle);
		dealspage = contactspage.enterContactDetails(prop.getProperty("firstname"), prop.getProperty("lastname"),
				prop.getProperty("department"));
	}

	@Then("User enters the new Deals page and verifys title and enters the deals details")
	public void user_enters_the_new_Deals_page_and_verifys_title_and_enters_the_deals_details() throws InterruptedException {
		String dealpagetitle = dealspage.title();
		Assert.assertEquals("CRMPRO", dealpagetitle);

		taskspage = dealspage.enterDealsDetails(prop.getProperty("dealtitle"), prop.getProperty("contactname"));
	}
}
