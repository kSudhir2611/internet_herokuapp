package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class FileDownloadUpload extends SupportClass
{
	@Test(priority=1)
	public void fileDownload() 
	{
		WebElement eleDownload = wd.findElement(By.linkText("File Download"));
		eleDownload.click();
		
		//download first file
		wd.findElement(By.linkText("sample1.pdf")).click();
		//download second file
		wd.findElement(By.linkText("test.pdf")).click();
	}
	
	@Test(priority=2)
	public void fileUpload() 
	{
		WebElement eleUpload = wd.findElement(By.linkText("File Upload"));
		eleUpload.click();
		
		WebElement fileUpload = wd.findElement(By.id("file-uplosd"));
		fileUpload.click();
		fileUpload.sendKeys("C:\\Users\\Selenuium\\info.json");
		
		WebElement uploadElement = wd.findElement(By.id("file-submit"));
		uploadElement.click();
		
		WebElement msgElement = wd.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']"));
		
		if(msgElement.isDisplayed()) 
		{
			System.out.println("File Uploaded successfully");
		}
		else 
		{
			System.out.println("File not Uploaded");
		}
		
		
	}
}
