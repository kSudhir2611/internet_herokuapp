package Test_Cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class InfiniteScroll extends SupportClass
{
	@Test
	public void handlingScroling() throws InterruptedException 
	{
		WebElement eleScrollLink = wd.findElement(By.linkText("Infinite Scroll"));
		eleScrollLink.click();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)wd;
		//Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//Thread.sleep(5000);
	}
}
