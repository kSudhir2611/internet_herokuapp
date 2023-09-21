package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Support.SupportClass;

public class Hovers extends SupportClass
{
	@Test
	public void handlingHovers() 
	{
		WebElement eleHoverLink = wd.findElement(By.linkText("Hovers"));
		
		eleHoverLink.click();
		
		WebElement user1 = wd.findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
		WebElement user2 = wd.findElement(By.xpath("//div[@class='example']//div[2]//img[1]"));
		WebElement user3 = wd.findElement(By.xpath("//div[@class='example']//div[3]//img[1]"));
		
		Actions act = new Actions(wd);
		
		act.moveToElement(user1).moveToElement(user2).moveToElement(user3).perform();
	}
}
