package com.test.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest(){
		super();   				//initializes the properties file from the test base class constructor
		
	}
	@BeforeMethod
	public void setup(){
		
		initialization();
		loginPage = new LoginPage();
		
	}
	
	//@Test(priority=1)
	public void loginPageTitleTest(){
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	//@Test(priority=2)
	public void loginPageLogoTest(){
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	

}
