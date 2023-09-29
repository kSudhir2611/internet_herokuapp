package Test_Cases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class AlertHandling extends SupportClass
{
	@Test
	public void handlingSimpleAlert() 
	{
		WebElement eleAlertLink = wd.findElement(By.linkText("JavaScript Alerts"));
		eleAlertLink.click();
		log.info("clicked on  javascript alert element link");
		WebElement jsAlert = wd.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		jsAlert.click();
		log.info("Clicked on js alert button");
		
		Alert alert = wd.switchTo().alert();
		log.info("Switched to alert");
		alert.accept();
		log.info("clicked on OK button");
		
		String alertMsg = wd.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(alertMsg);
	}
	
	
	@Test(priority=1)
	public void handlingConfirmationAlert() 
	{
		WebElement eleAlertLink = wd.findElement(By.linkText("JavaScript Alerts"));
		eleAlertLink.click();
		WebElement confirmAlert = wd.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		confirmAlert.click();
		log.info("clicked on  js confirm element link");
		
		Alert alert = wd.switchTo().alert();
		log.info("Switched to alert");
		//alert.accept();
		//log.info("clicked on accept button");
		alert.dismiss();
		log.info("clicked on cancel button");
		
		String alertMsg = wd.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(alertMsg);
		
	}
	@Test(priority=2)
	public void handlingPromptAlert() 
	{
		WebElement eleAlertLink = wd.findElement(By.linkText("JavaScript Alerts"));
		eleAlertLink.click();
		WebElement propmtAlert = wd.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		propmtAlert.click();
		log.info("clicked on  js propmpt element link");
		
		Alert alert = wd.switchTo().alert();
		log.info("Switched to alert");
		System.out.println(alert.getText());
		alert.sendKeys("Selenium with Java");
		log.info("Entered text into input box");
		alert.accept();
		log.info("Clicked on OK button");
		
	}
}
