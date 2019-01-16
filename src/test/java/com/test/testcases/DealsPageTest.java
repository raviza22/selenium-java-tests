package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.DealsPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.util.TestUtil;

public class DealsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	
	String sheetName = "deals";
	
	
	public DealsPageTest(){
		super();   				//initializes the properties file from the test base class constructor	
	}
	@BeforeMethod
	public void setup(){
		
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test(priority=1)
	public void verifyDealsPageLabel(){
		Assert.assertTrue(dealsPage.validateDealsLabel(), "Deals label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=2, dataProvider="getData")
	public void createNewDealTest(String title, String company, String amount){
		homePage.clickOnNewDealLink();
		dealsPage.validateCreateNewDeal(title, company, amount);
		
	}
	

	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	

}
