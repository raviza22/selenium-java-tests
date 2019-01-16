package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.base.TestBase;

public class DealsPage extends TestBase {

	public DealsPage(){
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath ="//td[contains(text(), 'Deals')]")
	WebElement dealsLabel;

	@FindBy(id="title")
	WebElement dealTitle;

	@FindBy(name ="client_lookup")
	WebElement companyName;

	@FindBy (name="amount")
	WebElement dealAmount;

	@FindBy (xpath ="//input[@type='submit' and @value = 'Save']")
	WebElement saveButton;

	public boolean validateDealsLabel() {
		return dealsLabel.isDisplayed();
		
	}

	public void validateCreateNewDeal(String title, String company, String amount) {
		 dealTitle.sendKeys(title);
		 companyName.sendKeys(company);
		 dealAmount.sendKeys(amount);
		 saveButton.click();
	}
	
}
