package Test_Cases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Support.SupportClass;

public class DynamicContent extends SupportClass
{
	@Test
	public void printDynamicContent() 
	{
		
		WebElement eleDynContentLink = wd.findElement(By.linkText("Dynamic Content"));
		eleDynContentLink.click();
		// to store information
		List<String> pictures = new ArrayList<>();
		List<String> posts = new ArrayList<>();
		
		int totalPictures = 7;
		int totalComments = 0;
		int pictureShown = 3;
		int commentshown = 3;
		int tries  =1;
		
		
		
		while(pictures.size() < totalPictures && posts.size() < 1000) 
		{
			//to iterate through differant profile pictures
			for(int i=0;i<totalPictures;i++) 
			{
				WebElement avatar = wd.findElement(By.xpath("//body//div[@class='row']//div[@id='content']//div[@id='content']//div[3]//div[1]//img"));
				String avatarRoute = avatar.getAttribute("src");
				
				//add picture url to list
				if(!pictures.contains(avatarRoute)) 
				{
					pictures.add(avatarRoute);
				}
				
			}
			
			// Then, aim for the comments, locate them, extract the text, and sum the amount of comments
            for (int i = 0; i < commentshown; i++) 
            {
                WebElement post = wd.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[" + (i + 1) + "]/div[2]"));
                String postText = post.getText();
                System.out.println(postText);
                totalComments++;

                // If the comment isn't in its list already, store it
                if (!posts.contains(postText)) {
                    posts.add(postText);
                } else {
                    System.out.println("There are no new posts");
                }
            }

            // Count the number of iterations as we don't know how many different comments there are
            tries++;
            System.out.println(pictures);
            System.out.println(String.join("\n\nCOMENT BATCH #" + posts.size() + "   ", posts));
            System.out.println(tries + " " + totalPictures + " " + totalComments);
            wd.navigate().refresh();
		}
		
		
	}
}
