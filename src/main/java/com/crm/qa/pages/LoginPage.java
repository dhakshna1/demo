package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")
	//@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		System.out.println("User name entered");
		password.sendKeys(pwd);
		System.out.println("Password entered");
		loginBtn.click();
		System.out.println("Login button submitted");
		Thread.sleep(10000);		
		return new HomePage();
	}
}
