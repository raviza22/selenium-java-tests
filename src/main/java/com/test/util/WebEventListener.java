package com.test.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.test.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	public void beforeNavigateTo(String url, WebDriver driver){
		System.out.println("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver){
		System.out.println("Navigated to: '" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2){
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] arg2){
		System.out.println("Element value changed to:" + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver){
		System.out.println("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver){
		System.out.println("Clicked on: " + element.toString());
	}

	public void beforeNavigateBack( WebDriver driver){
		System.out.println("Navigating back to previous page");
	}

	public void afterNavigateBack( WebDriver driver){
		System.out.println("Navigated back to previous page");
	}

	public void beforeNavigateForward( WebDriver driver){
		System.out.println("Navigating forward to next page");
	}

	public void afterNavigateForward( WebDriver driver){
		System.out.println("Navigated forward to next page");
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element by: " + by.toString());

	}
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element by: " + by.toString());

	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured " + error);
	try{
			TestUtil.takeScreenshot();
			}catch(IOException e){
				e.printStackTrace();
			}
			
	}
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert accepted");

	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert dismissed");

	}
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Page refreshed");

	}


	public void afterScript(String s, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String url, WebDriver driver) {
		System.out.println("Switched to window: " + url);

	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before accepting alert");

	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before dismissing alert");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before page refresh");

	}

	public void beforeScript(String s, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String url, WebDriver driver) {
		System.out.println("Before switching to window: " + url);

	}

	

}
