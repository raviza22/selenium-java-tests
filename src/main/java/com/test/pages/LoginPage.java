package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.test.base.TestBase;

public class LoginPage extends TestBase{
	
	// Page Factory - OR
	
	@FindBy (name="username")
	@CacheLookup
	WebElement username;
	@FindBy (name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy (xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy (xpath="//img[contains(@class, 'img-responsive')]")
	WebElement logo;
	
	@FindBy (id="preloader")
	@CacheLookup
	WebElement preloader;
	
	// Initializing the page objects using page factory
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Page actions
	public String validateLoginPageTitle(){
		wait.until(ExpectedConditions.invisibilityOf(preloader));
		return driver.getTitle();
	}
	
	public boolean validateLogo(){
		wait.until(ExpectedConditions.invisibilityOf(preloader));
		return logo.isDisplayed();
	}
	
	public HomePage login(String user, String pass){
		wait.until(ExpectedConditions.invisibilityOf(preloader));
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		
		return new HomePage();
	}
	

}
