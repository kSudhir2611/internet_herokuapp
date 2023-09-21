package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class NotificationMessage extends SupportClass
{
	@Test
	public void notificationMessageHandling() throws InterruptedException 
	{
		WebElement eleLink = wd.findElement(By.linkText("Notification Messages"));
		eleLink.click();
		
		WebElement clickLink = wd.findElement(By.linkText("Click here"));
		
		for(int i=0;i<2;i++) 
		{
			clickLink.click();
			String notification_msg = wd.findElement(By.xpath("//div[@id='flash']")).getText();
			System.out.println(notification_msg);
			Thread.sleep(2000);
		}
	}
}
