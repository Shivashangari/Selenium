package TestNg;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonList {
	WebDriver Amazon;
	Scanner input = new Scanner(System.in);

	@Test(priority = 1)
	public void getDriver() {

		WebDriverManager.chromedriver().setup();
		Amazon = new ChromeDriver();
		Amazon.get("http://www.google.co.in");

		Amazon.findElement(By.name("q")).sendKeys("Amazon" + Keys.ENTER);

		Amazon.findElement(By.xpath("//*[@class=\"CCgQ5 vCa9Yd QfkTvb MUxGbd v0nnCb\"]")).click();

		Amazon.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mini Camera");

		Amazon.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		List<WebElement> products = Amazon.findElements(By.xpath("//*[@aria-labelledby=\"p_89-title\"]"));
		
		Amazon.findElement(By.xpath("a-expander-prompt")).click();
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			System.out.println(name);
			System.out.println("Enter the brand name");
			String brandname = input.nextLine();
			if (name.contains(brandname)) 
			{
				System.out.println("Brand is available");
			} 
			else
			{
				System.out.println("Brand is not available");
			}
		}
		/*
		 * System.out.println("please enter day :"); String a1 = input.nextLine(); for
		 * (int g = 0; g < dayArray.size(); g++){ if (dayArray.get(g).equals(a1))
		 * System.out.println("invalid day , please enter another day : "); a1 =
		 * input.nextLine(); }
		 * 
		 * 
		 * /*for (WebElement webElement : products) { String strlinktext =
		 * webElement.getText(); System.out.println(strlinktext);
		 */
	}

}
