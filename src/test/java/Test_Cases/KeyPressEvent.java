package Test_Cases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class KeyPressEvent extends SupportClass
{
	@Test
	public void keyPressAction() throws AWTException 
	{
		WebElement eleKeyPress =  wd.findElement(By.linkText("Key Presses"));
		eleKeyPress.click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		System.out.println(wd.findElement(By.xpath("//p[@id='result']")).getText());
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_SHIFT);
		System.out.println(wd.findElement(By.xpath("//p[@id='result']")).getText());
		robot.keyRelease(KeyEvent.VK_SHIFT);
		
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		System.out.println(wd.findElement(By.xpath("//p[@id='result']")).getText());
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		System.out.println(wd.findElement(By.xpath("//p[@id='result']")).getText());
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_ALT);
		System.out.println(wd.findElement(By.xpath("//p[@id='result']")).getText());
		robot.keyRelease(KeyEvent.VK_ALT);
		
		
		
		
		
	}
}
