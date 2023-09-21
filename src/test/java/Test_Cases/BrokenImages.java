package Test_Cases;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class BrokenImages extends SupportClass 
{
	@Test
	public void checkBrokenImages() throws MalformedURLException 
	{
		WebElement eleBrokenImages = wd.findElement(By.linkText("Broken Images"));
		eleBrokenImages.click();
		
		List<WebElement> allImages=wd.findElements(By.xpath("//div[@class='example']//img"));
		System.out.println("Number of Images: "+allImages.size());
		
		for(WebElement image:allImages) 
		{
			String url = image.getAttribute("src");
			
			URL link = new URL(url);
			
			try 
			{
				HttpURLConnection htcon = (HttpURLConnection)link.openConnection();
				
				htcon.connect();
				
				if(htcon.getResponseCode()>=400) 
				{
					System.out.println(url+" image is broken");
				}
				else 
				{
					System.out.println(url+" image is valid");
				}
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
