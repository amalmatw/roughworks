package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Prgm03test
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
	d.get("https://www.wappalyzer.com/");
	d.manage().window().maximize();
}

@Test
public void test() throws Exception
{
	d.findElement(By.xpath("//*[@class='d-none d-md-block flex-grow-1 flex-shrink-0 text-right col']/button[2]")).click();
	d.findElement(By.xpath("//a[@id='list-item-49']/div[1]")).click();
	Thread.sleep(5000);
	JavascriptExecutor js=(JavascriptExecutor)d;
	js.executeScript("window.scrollBy(0,350)");
	Thread.sleep(5000);
    d.findElement(By.xpath("//div[@class='v-select__selections']")).click();
    d.findElement(By.xpath("//input[contains(@id,'input') and @placeholder='E.g. ecommerce or Shopify']")).sendKeys("shopify");
    Thread.sleep(7000);
    d.findElement(By.xpath("//div[contains(text(),'Shopify apps')]")).click();
    Thread.sleep(5000);
    d.findElement(By.xpath("//a[@class='mt-2 v-btn v-btn--has-bg v-btn--router theme--light v-size--large primary']")).click();
    Thread.sleep(5000);
	
}

@AfterTest
public void closing()
{
	d.close();
}
}
