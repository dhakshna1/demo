package com.crm.qa.base;

import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.qa.util.TestUtil;
//create constructor and read your properties
public class TestBase{

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"E:\\workspace\\FreeCRMTest\\src\\" + "main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Driver opened");
		}
		/*else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.geckco.driver", "F:\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}*/
			driver.manage().window().maximize();
			System.out.println("Mazimised");
			driver.manage().deleteAllCookies();
			System.out.println("deleted all cookies");
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			System.out.println("Going to open URL");
			String url = prop.getProperty("url");
			System.out.println("URL is "+url);
			driver.get(url);
	}
	
}
