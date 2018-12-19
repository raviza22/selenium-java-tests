package com.test.util;

import com.test.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	public static long FLUENT_WAIT_TIMEOUT = 10;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}

}
