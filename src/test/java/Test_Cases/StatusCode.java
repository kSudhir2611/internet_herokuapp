package Test_Cases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Support.SupportClass;

public class StatusCode extends SupportClass
{
	@Test
	public void displayStatusCode() 
	{
		WebElement status_code = wd.findElement(By.linkText("Status Codes"));
		status_code.click();
		
		List<WebElement> allCode = wd.findElements(By.xpath("//div[@class='example']//ul//li//a"));
		WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(10));
		for(int i=0;i<allCode.size();i++) 
		{
			try 
			{
				WebElement st_code = allCode.get(i);
				st_code.click();
				String Status_msg = wd.findElement(By.xpath("//div[@class='example']//p")).getText();
				System.out.println(Status_msg);
			}
			catch(StaleElementReferenceException e)
			{
				e.printStackTrace();
			}
			
			wd.findElement(By.xpath("//a[normalize-space()='here']")).click();
			
		}
		
		
	}
}
