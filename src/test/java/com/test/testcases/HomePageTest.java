package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.ContactsPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();   				//initializes the properties file from the test base class constructor
		
	}
	
	@BeforeMethod
	public void setup(){
		
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUsernameLabel()); 
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	

}
