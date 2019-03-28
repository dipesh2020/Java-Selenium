package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class ProductNServicesPage extends TestBase {
	
	//pagefactory or a container
	// we will keep all the locator and method

	@FindBy(xpath="//span[text()='Products & Services']")
	WebElement ProductNServices;
	
	@FindBy(xpath="//a[text()='New Service']")
	WebElement NewServices;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement TypeName;
	
	@FindBy(xpath="//input[@id='sales_price']")
	WebElement SalesPrice;
	
	@FindBy(xpath="//input[@id='item_number']")
	WebElement ItemNumber;
	
	@FindBy(xpath="//textarea[@class='form-control']")
	WebElement Description;
	
	@FindBy(xpath="//button[@id='submit']")
	WebElement Submit;
	
	@FindBy(xpath="//div[@class='alert alert-success fade in']")
	WebElement SuccessMessage;
		
	
	//created PageFactory with the Constructor
	public ProductNServicesPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ProductNServices() {
		
		ProductNServices.click();
		
	}
	
	public void NewServices() {
		
		NewServices.click();
	}
	
	public void NewOrder(String Name, String salesPrice, String itemNumber, String description) {
	
		TypeName.sendKeys(Name);
		SalesPrice.sendKeys(salesPrice);
		ItemNumber.sendKeys(itemNumber);
		Description.sendKeys(description);
		Submit.click();
				
	}
	
	public boolean ValidateSuccessMessage() {
		
		return SuccessMessage.isDisplayed();
	}
}
