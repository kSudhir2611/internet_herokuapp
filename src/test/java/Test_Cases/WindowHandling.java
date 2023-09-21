package Test_Cases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class WindowHandling extends SupportClass
{
	@Test
	public void handleWindow() 
	{
		WebElement eleWinLink = wd.findElement(By.linkText("Multiple Windows"));
		eleWinLink.click();
		//get parent window id
		 String parent_wid = wd.getWindowHandle();
		 System.out.println("Parent window id: "+parent_wid);
		 
		 //click here
		 wd.findElement(By.linkText("Click Here")).click();
		 
		 //get id of multiple window
		Set<String>allwid= wd.getWindowHandles();
		
		for(String id:allwid) 
		{
			while(!id.equalsIgnoreCase(parent_wid)) 
			{
				wd.switchTo().window(id);
				String page_title = wd.getTitle();
				System.out.println(page_title);
				wd.close();
				break;
			}
			
		}
		wd.switchTo().window(parent_wid);
		System.out.println(wd.getTitle());	 
	}
}
