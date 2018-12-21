package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.base.TestBase;

public class ContactsPage extends TestBase{
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	//@FindBy(xpath ="//a[text()= 'test2 test2')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy (id="surname")
	WebElement lastName;
	
	@FindBy (name="client_lookup")
	WebElement company;
	
	@FindBy (xpath ="//input[@type='submit' and @value = 'Save']")
	WebElement saveButton;
	
	public boolean validateContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()= '"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void validateCreateNewContact(String title, String firstname, String lastname, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		company.sendKeys(comp);
		saveButton.click();
	}
	
}
