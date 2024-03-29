
/*
 1.It goes to a specific website called "http://the-internet.herokuapp.com/add_remove_elements/".

2. On that website, it can add new elements by clicking a button that says "Add Element".

3. It can also remove elements, but it needs some information from the user to do that.

4. If the user wants to remove more elements than there are currently on the screen, 
the program will tell them how many elements there are in total.
 * */
package Test_Cases;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class AddRemoveElement extends SupportClass
{
	Scanner sc = new Scanner(System.in);
	@Test
	public void addRemoveElement() throws InterruptedException 
	{
		
		
		//click on add/remove element link
		WebElement addRemove = wd.findElement(By.linkText("Add/Remove Elements"));
		addRemove.click();
		log.info("Click on Addremove element");
		
		System.out.println("Enter the number of Element to be added: ");
		int addedElement = sc.nextInt();
		System.out.println("Enter the number of element to be removed: ");
		int removeElement = sc.nextInt();
		log.info("Input taken from user for adding and removing element");
		
		int elementOnScreen = addedElement - removeElement;
		
		//process for adding element
		for(int i=0;i<addedElement;i++) 
		{
			WebElement addEle = wd.findElement(By.xpath("//button[@onclick='addElement()']"));
			addEle.click();
			log.info("clicked on Add button");
		}
		Thread.sleep(2000);
		
		//process of removing element
		for(int i=0;i<removeElement;i++) 
		{
			try 
			{
				WebElement removeEle = wd.findElement(By.xpath("//button[@class='added-manually']"));
				removeEle.click();
				log.info("clicked on delete element");
			}
			catch(Exception e) 
			{
				System.out.println("You are  trying to delete more element than exits");
				break;
			}
			
		}
		
		if(elementOnScreen > 0) 
		{
			System.out.println("There are "+elementOnScreen+" element on screen");
		}
		else 
		{
			System.out.println("There are 0 elemets on screen");
		}
		
		
	}
}
