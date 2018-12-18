package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.TestBase;

public class LoginPage extends TestBase{
	
	// Page Factory - OR
	@FindBy(id="UserType")
	WebElement usertype;
	@FindBy (id="Username")
	WebElement username;
	@FindBy (id="Password")
	WebElement password;
	@FindBy (id="loginButton")
	WebElement loginButton;
	
	@FindBy (id="logo")
	WebElement logo;
	// Initializing the page objects using page factory
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Page actions
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		return logo.isDisplayed();
	}
	
	public HomePage login(String type, String user, String pass){
		usertype.sendKeys(type);
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		
		return new HomePage();
	}
	

}
