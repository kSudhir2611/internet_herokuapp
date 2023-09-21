package Test_Cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DynamicLoading extends SupportClass
{
	@Test
	public void checkDynamicLoadingOfElement() 
	{
		WebElement eleDynLoading = wd.findElement(By.linkText("Dynamic Loading"));
		eleDynLoading.click();
		
		//clicking on example one
		WebElement exampleOne = wd.findElement(By.linkText("Example 1: Element on page that is hidden"));
		exampleOne.click();
		
		WebElement startButton = wd.findElement(By.xpath("//div[@id='start']//button"));
		startButton.click();
		
		WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(10));
		
		WebElement hiddenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()='Hello World!']")));
		
		String hiddenText = hiddenElement.getText();
		
		System.out.println("Element hidden is : "+hiddenText);
		
		
		
		
	}
}
