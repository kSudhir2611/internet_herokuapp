package Test_Cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class CheckBox extends SupportClass
{
	@Test
	public void clickCheckbox() 
	{
		WebElement eleCheckbox = wd.findElement(By.linkText("Checkboxes"));
		eleCheckbox.click();
		
		List<WebElement> allBox=wd.findElements(By.xpath("//div[@class='example']//form//input"));
		
		for(WebElement checkbox:allBox) 
		{
			if(checkbox.isSelected()) 
			{
				continue;
			}
			else 
			{
				checkbox.click();
			}
		}
		System.out.println("Checkboxs selected");
	}
	
	
}
