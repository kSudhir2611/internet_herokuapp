package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DisapperingElement extends SupportClass
{
	@Test
	public void findDisapperElement() 
	{
		wd.findElement(By.linkText("Disappearing Elements")).click();
		//for storing five element
		String[] options = new String[5];
		int menuCount = 5;
		int tries = 1;
		
		while(options[4]==null) 
		{
			options = new String[5];
			
			for(int i=0;i<menuCount;i++) 
			{
				try 
				{
					WebElement optionName = wd.findElement(By.xpath("//ul//li["+(i+1)+"]//a"));
					options[i] = optionName.getText();
					System.out.println(String.join(",", options));
				}
				catch(Exception e) 
				{
					System.out.println("option number "+(i+1)+" is NOT FOUND");
					tries += 1;
					wd.navigate().refresh();
				}
			}
		}
		System.out.println("Tries finished in "+tries+" tries");
	}
}
