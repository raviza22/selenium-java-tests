package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath ="//td[contains(text(), 'User: raviza raviza')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath ="//a[contains(text(), 'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;

	@FindBy (xpath="//a[text()='New Contact']")
	WebElement newContactLink;
	//Initializing the page objects using page factory
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUsernameLabel(){
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();		
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}


}
