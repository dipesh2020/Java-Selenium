package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestUtil.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	
	public void SetUp() {
		logger.info("Opening Browser");
		initil();
		loginpage = new LoginPage();
	}
	
	@Test (priority = 3)	
	public void VerifyLoginPage() {
		
		logger.info("Verifying login");
		loginpage.VerifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		TestUtil.captureScreenShot(driver, "Login Page");
		
	}
	
	@Test (priority = 0)
	public void VerifyLogoofthePage() {
		logger.info("Verifying Logo of the Page");
		boolean logo = loginpage.verifyLogo();
		Assert.assertTrue(logo);
		TestUtil.captureScreenShot(driver, "LogoOfthePage");
		
		
	}
	
	@Test (priority = 1)
	public void VerifyTitleofthePage() {
		
		logger.info("Verify Title of the Page");
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
		TestUtil.captureScreenShot(driver, "TitleOfthePage");
	}
	
	@Test (priority = 2)
	public void VerifyErrorMessageWithInvaliduspw() throws Exception {
		
	loginpage.ErrorMessage(prop.getProperty("invalidUsername"), prop.getProperty("invalidPassword"));
	Thread.sleep(5000);
	boolean er = loginpage.VerifyError();
	Assert.assertTrue(er);
	TestUtil.captureScreenShot(driver, "Error Message Page");
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
