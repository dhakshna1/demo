package com.crm.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage LoginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage = new LoginPage();
			
	}
	
	@Test (priority=1)
	public void loginPageTitleTest() {
		String title = LoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		System.out.println("Test case Passed");
	}
	
	@Test (priority=2)
	public void CRMLogoImageTest() {
		boolean flag = LoginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test (priority=3)
	public void loginTest() {
		try {
			homePage = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
