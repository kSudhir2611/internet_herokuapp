package Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DataTablePrint extends SupportClass 
{
	@Test
	public void dataTablehandling() 
	{
		WebElement eleDatatableLink = wd.findElement(By.linkText("Sortable Data Tables"));
		eleDatatableLink.click();
		
		int rowCount = wd.findElements(By.xpath("//table[@id='table1']//tr")).size();
		
		int colCount = wd.findElements(By.xpath("//table[@id='table1']//thead//tr//th")).size();
		
		for(int i=1;i<=rowCount;i++) 
		{
			String lastname = wd.findElement(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td[1]")).getText();
			String firstname = wd.findElement(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td[2]")).getText();
			String email = wd.findElement(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td[3]")).getText();
			String due = wd.findElement(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td[4]")).getText();
			String website = wd.findElement(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td[5]")).getText();
			
			System.out.println(lastname+"  "+firstname+"  "+email+"  "+due+"  "+website);
			
		}
		
	}
}
