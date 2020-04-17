package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public TestBase() {
		try {
			prop =new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\sivag\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\com\\qa\\properties\\cucumberPOM.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
	       e.printStackTrace();
		}
	}
   public static void initialization() {
	   String browsername= prop.getProperty("browser");
	   if(browsername.equals("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   driver.get(prop.getProperty("url"));
	   }
   }
}
