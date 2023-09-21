package Test_Cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DropDown extends SupportClass
{
	@Test
	public void handleDropdown() 
	{
		WebElement eleDropdownlink = wd.findElement(By.linkText("Dropdown"));
		eleDropdownlink.click();
		
		// dropdown element
		WebElement element_drp = wd.findElement(By.xpath("//select[@id='dropdown']"));
		
		Select dropdown = new Select(element_drp);
		
		List<WebElement>allOption=dropdown.getOptions();
		
		for(int i=0;i<allOption.size();i++) 
		{
			String eleText = allOption.get(i).getText();
			if(eleText.equals("Option 2")) 
			{
				allOption.get(i).click();
				break;
			}
		}
		
		WebElement option2 = wd.findElement(By.xpath("//select[@id='dropdown']//option[@value='2']"));
		
		if(option2.isSelected()) 
		{
			System.out.println("Option2 selected");
		}
		else 
		{
			System.out.println("Option2 not selected");
		}
	}
}
