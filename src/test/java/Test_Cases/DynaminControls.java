package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DynaminControls extends SupportClass
{
	@Test
	public void dynamicControlButton() throws InterruptedException 
	{
		WebElement eleDynCtrl = wd.findElement(By.linkText("Dynamic Controls"));
		eleDynCtrl.click();
		
		//indentify chech box click it ,and click on remove button
		WebElement checkBox = wd.findElement(By.xpath("//input[@type='checkbox']"));
		checkBox.click();
		
		WebElement removeButton = wd.findElement(By.xpath("//button[normalize-space()='Remove']"));
		removeButton.click();
		
		WebElement addButton = wd.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
		addButton.getClass();
		
		if(checkBox.isDisplayed()) 
		{
			System.out.println("Add operation is successful");
		}
		else 
		{
			System.out.println("Add operation failed");
		}
		
		Thread.sleep(10000);
		//enable textbox and enter text into box and disble
		WebElement enableButton = wd.findElement(By.xpath("//button[normalize-space()='Enable']"));
		WebElement textBox = wd.findElement(By.xpath("//input[@type='text']"));

		if(textBox.isEnabled()) 
		{
			System.out.println("Textbox is enabled");
			textBox.sendKeys("Selenium with java");
		}
		
		wd.findElement(By.xpath("//button[normalize-space()='Disable']")).click();
		
		
	}
}
