package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DragAndDrop extends SupportClass
{
	@Test
	public void performDragAndDrop() 
	{
		WebElement eleDragDrop = wd.findElement(By.linkText("Drag and Drop"));
		
		eleDragDrop.click();
		
		//dragable element
		WebElement eleDragable = wd.findElement(By.xpath("//div[@id='column-a']"));
		//Dropable Element
		WebElement eleDropable = wd.findElement(By.xpath("//div[@id='column-b']"));
		
		Actions builder = new Actions(wd);
		
		Action act = builder.clickAndHold(eleDragable)
					.moveToElement(eleDropable)
					.release(eleDropable).build();
		
		act.perform();
	}
}
