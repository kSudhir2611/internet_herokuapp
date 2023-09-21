package Support;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class SupportClass 
{
	public WebDriver wd;
	
	@Parameters({"browserName"})
	@BeforeClass
	public void launchBrowser(@Optional("chrome")String brname) 
	{
		if(brname.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
		}
		else if(brname.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
		}
		else if(brname.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			wd = new EdgeDriver();
		}
		
		
		wd.get("https://the-internet.herokuapp.com/");
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public  void screenshotOnfailure() throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)wd;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String trg = System.getProperty("user.name")+".//Screenshot//screenshot"+dtm()+" .png";
		
		FileUtils.copyFile(src, new File(trg));
	}
	
	public String dtm() 
	{
		return new SimpleDateFormat().format(new Date());
	}
	
	@AfterClass
	public  void tearDown() 
	{
		wd.quit();
	}
}