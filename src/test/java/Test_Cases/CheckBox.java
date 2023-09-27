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
		log.info("Click on element link");
		
		List<WebElement> allBox=wd.findElements(By.xpath("//div[@class='example']//form//input"));
		log.info("Find aal the check box on page");
		for(WebElement checkbox:allBox) 
		{
			if(checkbox.isSelected()) 
			{

				continue;
			}
			else 
			{
				log.info("Checkbox is clicked");
				checkbox.click();
			}
		}
		System.out.println("Checkboxs selected");
	}
	
	
}
