package Test_Cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DigestAuthentication extends SupportClass
{
	@Test
	public void performDigestAuthentication() 
	{
		wd.navigate().to("https://admin:admin@https://the-internet.herokuapp.com/basic_auth");
	
		
		String expMsg = wd.findElement(By.xpath("//div[@class='example']//p")).getText();
		
		String actMsg = "Congratulations! You must have the proper credentials.";
		
		if(expMsg.equals(actMsg)) 
		{
			System.out.println("Digest Authentication is Successful");
		}
		else 
		{
			System.out.println("Digest Authentication failed");
		}
	}
}
