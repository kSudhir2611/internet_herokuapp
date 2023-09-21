package Test_Cases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Support.SupportClass;

public class JQuiryUIMenu extends SupportClass
{
	@Test
	public void handlingJQuiryDropDown() throws AWTException 
	{
		WebElement eleJQuiryLink = wd.findElement(By.linkText("JQuery UI Menus"));
		eleJQuiryLink.click();
		
		WebElement disabled = wd.findElement(By.linkText("//a[normalize-space()='Disabled']"));
		disabled.click();
		
		Robot robot = new Robot();
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
	}
}
