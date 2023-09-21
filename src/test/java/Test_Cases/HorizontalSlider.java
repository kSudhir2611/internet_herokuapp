package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Support.SupportClass;

public class HorizontalSlider extends SupportClass
{
	@Test
	public void handlingSlider() 
	{
		WebElement eleSliderLink = wd.findElement(By.linkText("Horizontal Slider"));
		eleSliderLink.click();
		
		WebElement slider = wd.findElement(By.xpath("//input[@value='0']"));
		
		Actions act = new Actions(wd);
		
		System.out.println("slider position before moving: "+slider.getLocation());
		
		act.dragAndDropBy(slider, 0, 100).perform();
		
		System.out.println("slider position after moving: "+slider.getLocation());
		
		
	}
}
