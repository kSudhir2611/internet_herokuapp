package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class FormAuthentication extends SupportClass
{
	@Test
	public void formAuthentication() throws InterruptedException 
	{
		WebElement eleformAuth = wd.findElement(By.linkText("Form Authentication"));
		eleformAuth.click();
		
		//login into secure area
		WebElement username = wd.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		WebElement passwrd = wd.findElement(By.id("password"));
		passwrd.sendKeys("SuperSecretPassword!");
		
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		
		String expMsg = "You logged into a secure area";
		String actMsg = wd.findElement(By.xpath("//div[@id='flash']")).getText();
		
		if(actMsg.contains(expMsg)) 
		{
			System.out.println(actMsg);
		}
		else
		{
			System.out.println("Login is Unsuccessful");
		}
	
		//logout
		Thread.sleep(3000);
		wd.findElement(By.xpath("//a[@class='button secondary radius']")).click();
		Thread.sleep(5000);
		String logoutMsg = wd.findElement(By.xpath("//div[@id='flash']")).getText();
		Thread.sleep(5000);
		System.out.println(logoutMsg);
		
		
	}
}
