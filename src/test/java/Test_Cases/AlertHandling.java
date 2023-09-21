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
		WebElement jsAlert = wd.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		jsAlert.click();
		
		Alert alert = wd.switchTo().alert();
		alert.accept();
		
		String alertMsg = wd.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(alertMsg);
	}
	
	
	@Test(priority=1)
	public void handlingConfirmationAlert() 
	{
		WebElement confirmAlert = wd.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		confirmAlert.click();
		
		Alert alert = wd.switchTo().alert();
		//alert.accept();
		alert.dismiss();
		
		String alertMsg = wd.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(alertMsg);
		
	}
	@Test(priority=2)
	public void handlingPromptAlert() 
	{
		WebElement propmtAlert = wd.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		propmtAlert.click();
		
		Alert alert = wd.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Selenium with Java");
		alert.accept();
		
	}
}
