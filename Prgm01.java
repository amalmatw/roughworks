package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prgm01 
{
	WebDriver d;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		d=new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlloading()
	{
		d.get("https://www.facebook.com");
		
	}
	
	@Test(priority=4, groups={"sanity"})
	public void atest01()
	{
		System.out.println("logo verification");
	}
	
	@Test(priority=3,enabled=false)
	public void ctest02()
	{
		System.out.println("button verification");
	}
	
	@Test(priority=1,  groups={"sanity", "smoke"})
	public void btest03()
	{
		System.out.println("radio button verification");
	}
	
	@Test(priority=2,invocationCount=3,groups={"smoke", "rgression"})
	public void dtest04()
	{
		System.out.println("screenshot");
	}
	
	@AfterMethod
	public void aftertest()
	{
		System.out.println("finish");
	}
	
	@AfterTest
	public void close()
	{
		System.out.println("test completed");
		
	}

}
