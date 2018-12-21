package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.ContactsPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super();   				//initializes the properties file from the test base class constructor
		
	}
	
	@BeforeMethod
	public void setup(){
		
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.validateContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest(){
		contactsPage.selectContactsByName("test test");
		
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test test");
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=4, dataProvider="getData")
	public void createNewContactTest(String title, String firstname, String lastname, String company){
		homePage.clickOnNewContactLink();
		contactsPage.validateCreateNewContact(title, firstname, lastname, company);
		
		//contactsPage.createNewContact("Mr.", "test3", "test3", "google");
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

}
