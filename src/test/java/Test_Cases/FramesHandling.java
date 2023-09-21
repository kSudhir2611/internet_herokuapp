package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Support.SupportClass;

public class FramesHandling extends SupportClass
{
	//@Test
	public void HandlingNestedFrame() 
	{
		WebElement eleFrameLink = wd.findElement(By.linkText("Frames"));
		eleFrameLink.click();
		
		//clicking on nested frame
		wd.findElement(By.linkText("Nested Frames")).click();
		//top frame
		WebElement topFrame = wd.findElement(By.name("frame-top"));
		wd.switchTo().frame(topFrame);
		//left frame
		/*WebElement leftFrame = wd.findElement(By.name("frame-left"));
		wd.switchTo().frame(leftFrame);
		String left = wd.findElement(By.xpath("//body")).getText();
		System.out.println("We are @ "+left+" frame");*/
		
		//Middle frame
		/*WebElement middleFrame = wd.findElement(By.xpath("//frame[@name='frame-middle']"));
		wd.switchTo().frame(middleFrame);
		String middle = wd.findElement(By.xpath("//body")).getText();
		System.out.println("We are @ "+middle+" frame");*/
		
		//Right Frame
		WebElement rightFrame = wd.findElement(By.xpath("//frame[@name='frame-right']"));
		wd.switchTo().frame(rightFrame);
		String right = wd.findElement(By.xpath("//body")).getText();
		System.out.println("We are @ "+right+" frame");
		
		//switching to default content
		wd.switchTo().defaultContent();
		//Bottom frame
		WebElement bottomFrame = wd.findElement(By.xpath("//frame[@name='frame-bottom']"));
		wd.switchTo().frame(bottomFrame);
		String bottom = wd.findElement(By.xpath("//body")).getText();
		System.out.println("We are @ "+bottom+" frame");
	}
	@Test
	public void handlingiFrame() throws InterruptedException 
	{
		WebElement eleFrameLink = wd.findElement(By.linkText("Frames"));
		eleFrameLink.click();
		
		//click on iframe link
		wd.findElement(By.linkText("iFrame")).click();
		
		WebElement frameElement = wd.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		
		wd.switchTo().frame(frameElement);
		
		Actions act = new Actions(wd);
		
		WebElement text = wd.findElement(By.xpath("//body"));
		System.out.println(text.getText());
		act.moveToElement(text).perform();
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
	
	}
}
