package com.xem.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xem.qa.base.TestBase;
import com.xem.qa.pages.DataStrategyPage;
import com.xem.qa.pages.HomePage;
import com.xem.qa.pages.LoginPage;
import com.xem.qa.pages.NewDataSourcePage;
import com.xem.qa.util.TestUtil;

public class NewDataSourceTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	NewDataSourcePage newDatasource;
	DataStrategyPage dataStrategyPage;
	
	public NewDataSourceTest() 
	{
		super();
}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		homePage = 	loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void createNewDataSource() throws Exception {
	
		newDatasource=new NewDataSourcePage();
		newDatasource.CreateNewDataSourcePage();
		testLog();
		
		
	}

	
}
