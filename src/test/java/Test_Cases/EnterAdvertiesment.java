package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class EnterAdvertiesment extends SupportClass
{
	@Test
	public void entryAdverties() 
	{
		WebElement eleEntry = wd.findElement(By.linkText("Entry Ad"));
		eleEntry.click();
		
		//close entry and again enable it
		wd.findElement(By.xpath("//p[normalize-space()='Close']")).click();
		
		wd.findElement(By.xpath("click here"));
		
		wd.navigate().refresh();
		
		WebElement adverties = wd.findElement(By.xpath("//div[@class='modal']"));
		
		if(adverties.isDisplayed()) 
		{
			System.out.println("Adverties displayed!");
		}
		else 
		{
			System.out.println("adverties Not Displayed");
		}
	}
}
