package com.tutorialninja.qa.testcases;




import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
	
WebDriver d=null;

	
	
	@BeforeMethod
	public void testbefore()
	{
		
	 String browser="edge";
	 
	 
	 if(browser.equals("chrome"))
	 {
	  d=new ChromeDriver();
		
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		 
		d.get("https://tutorialsninja.com/demo/");		
		
	 }
		
	 
	 if(browser.equals("edge"))
	 {
	  d=new FirefoxDriver();
		
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		 
		d.get("https://tutorialsninja.com/demo/");		
		
	 }
	 if(browser.equals("edge"))
	 {
	  d=new EdgeDriver();
		
		
		d.manage().window().maximize();
		
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		 
		d.get("https://tutorialsninja.com/demo/");		
		
	 }
	}
	@Test(priority=1)
	public void verifyLoginwithValidCredentials()
	{
		
		
          System.out.println("Test1");

		
		
		d.findElement(By.xpath("//span[contains(text(),\"My Account\")]")).click();

		
		d.findElement(By.xpath("\r\n"
				+ "//a[contains(text(),\"Login\")]\r\n"
				+ "")).click();
		
		
		d.findElement(By.name("email")).sendKeys("gayatri.ramasubramanian@gmail.com");
		
		d.findElement(By.name("password")).sendKeys("Gayatri3009@");
		
		
		d.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		
	     Assert.assertEquals(d.findElement(
	    		 
	    		 By.xpath("//a[contains(text(),\"Edit your account information\")]")).isDisplayed(),true);
	     
		
		
	        System.out.println("at the end");
			
		
		
	}
	
	
	
	
	@Test(priority=2)
	public void verifyLoginwithInValidCredentials()
	{
	
		
		
		System.out.println("Test2");

		
		
		d.findElement(By.xpath("//span[contains(text(),\"My Account\")]")).click();

		
		d.findElement(By.xpath("\r\n"
				+ "//a[contains(text(),\"Login\")]\r\n"
				+ "")).click();
		
		
		
//		System.out.println(generateTimestamp());
		
		d.findElement(By.name("email")).sendKeys("gayatggri.ramasubramanian@gmail.com"+generateTimestamp());
		
		d.findElement(By.name("password")).sendKeys("Gayatri3009@");
		
		
		d.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		
	     Assert.assertEquals(d.findElement(
	    		 
	    		 
	     By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),"Warning: No match for E-Mail Address and/or Password.");
	     
		

	     
		
		
			
		
	}
	
	@AfterMethod
	public void teardown()
	{
		
		d.quit();
		
		
	}
	
	@Test(priority=3)
	public void verifyLoginwithemptyandemptyPassword()
	{
	
		
		
		
		System.out.println("Test3");
		
		d.findElement(By.xpath("//span[contains(text(),\"My Account\")]")).click();

		
		d.findElement(By.xpath("\r\n"
				+ "//a[contains(text(),\"Login\")]\r\n"
				+ "")).click();
		
		
		
//		System.out.println(generateTimestamp());
		
		d.findElement(By.name("email")).sendKeys("");
		
		d.findElement(By.name("password")).sendKeys("");
		
		
		d.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		
		
	     Assert.assertEquals(d.findElement(
	    		 
	    		 
	     By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),"Warning: No match for E-Mail Address and/or Password.");
	     
		

	     
		
		
			
		
	}
	
	

	public String generateTimestamp()
	{
	
		Date d=new Date();
		
		
		//System.out.println(d.toString());
		
		
		
		return d.toString().replace(" ", "_").replace(":", "_");
		
	}
	
	
}
