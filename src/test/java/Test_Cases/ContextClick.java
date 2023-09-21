package Test_Cases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Support.SupportClass;

public class ContextClick extends SupportClass
{
	@Test
	public void performContextClick() throws InterruptedException 
	{
		WebElement eleContext = wd.findElement(By.linkText("Context Menu"));
		eleContext.click();
		
		WebElement element=wd.findElement(By.xpath("//div[@id='hot-spot']"));
		Actions builder = new Actions(wd);
		builder.contextClick(element).perform();
		
		Thread.sleep(2000);
		
		Alert alert=null;
		try 
		{
			alert = wd.switchTo().alert();
		}
		catch(NoAlertPresentException e) 
		{
			e.printStackTrace();
		}
		
		String expMsg = alert.getText();
		System.out.println(expMsg);
		
		String actMsg = "You selected a context menu";
		
		if(expMsg.equals(actMsg)) 
		{
			System.out.println("Context menu selected");
		}
		else 
		{
			System.out.println("context menu not selected");
		}
		alert.accept();
	}
	
}
