package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class BasicAuth extends SupportClass
{
	@Test
	public void basicAuthentication() 
	{

		wd.get("https://admin:admin@the-internet.herokuapp.com/");
		
		String actMsg = wd.findElement(By.xpath("//div[@id='content']//div//p")).getText();
		String expMsg = "Congratulations! You must have the proper credentials.";
				
		if(actMsg.equals(expMsg)) 
		{
			System.out.println("Basic Authentication is successful");
		}
		else 
		{
			System.out.println("Basic Authentication failed");
		}
		
	}
	
	
	
	
}
