package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase{

	//pagefactory or a container
	// we will keep all the locator and method
	
	@FindBy(xpath="//input[@id='username']")
	WebElement Username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SignInButton;
	
	@FindBy(xpath="//img[@class='logo']")
	WebElement Logo;
	
	@FindBy(xpath="//div[@class='alert alert-danger fade in']")
	WebElement ErrorMessage;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//All Action
	
	public void VerifyLogin(String Un, String Pw) {
		
		Username.sendKeys(Un);
		Password.sendKeys(Pw);
		SignInButton.click();
				
	}
	
	public String VerifyTitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyLogo() {
		
		return Logo.isDisplayed();
	}
	
	
	public void ErrorMessage(String eUn, String ePw) {
		
		Username.sendKeys(eUn);
		Password.sendKeys(ePw);
		SignInButton.click();
				
	}
	
	public boolean VerifyError() {
		return ErrorMessage.isDisplayed();
		
	}

	
}
