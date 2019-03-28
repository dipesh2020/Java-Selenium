package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;
import com.TestPages.ProductNServicesPage;
import com.TestUtil.TestUtil;

public class ProductNServicesPageTest extends TestBase{

	LoginPage loginpage;
	ProductNServicesPage productNServicesPage;
	String sheetName = "myFirstSheet";
	
	public ProductNServicesPageTest() {
		
		super();
		
	}
	
@BeforeMethod
	
	public void SetUp() {
		//logger.info("Opening Browser");
		
		initil();
		loginpage = new LoginPage();
		productNServicesPage = new ProductNServicesPage();
		loginpage.VerifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
@DataProvider

public Object[][] moon(){
	
	Object [][] data = TestUtil.getTestData(sheetName);
	return data;
	
	
}

@Test(dataProvider="moon")
	public void CreateNewOrder(String Name, String SalesPrice, String ItemNumber, String Description) throws Exception {
	Thread.sleep(5000);
	productNServicesPage.ProductNServices();
	Thread.sleep(5000);
	productNServicesPage.NewServices();
	Thread.sleep(5000);
	//productNServicesPage.NewOrder("Dipesh", "555", "4864", "Sexy");
	productNServicesPage.NewOrder(Name, SalesPrice, ItemNumber, Description);
	
	Thread.sleep(10000);
	
	boolean msg = productNServicesPage.ValidateSuccessMessage();
	Thread.sleep(10000);
	Assert.assertTrue(msg);
	
}
@AfterMethod
	public void TearDown() {
	driver.quit();
}
}
