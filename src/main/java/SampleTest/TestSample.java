package SampleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSample {
	@Test
	 public void sample() {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver Test = new ChromeDriver();
		Test.get("https://mytestingthoughts.com/Sample/home.html");
		Test.findElement(By.xpath("//*[@name=\"first_name\"]")).sendKeys("Shiva");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div/div/div/input")).sendKeys("Shiva");
		
		Test.findElement(By.xpath("//*[@name=\"last_name\"]")).sendKeys("Shangari");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[2]/div/div/input")).sendKeys("shangari");
		
		Test.findElement(By.xpath("//*[@id=\"inlineRadioFemale\"]")).click();
		Test.findElement(By.xpath("/html/body/div/form/fieldset/div[3]/div/div[2]/input")).click();
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[6]/div/div/input")).click();
		
		Test.findElement(By.xpath("//*[@name=\"user_name\"]")).sendKeys("Shivashangari");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[6]/div/div/input")).sendKeys("Shivashangari");
		

		Test.findElement(By.xpath("//*[@name=\"user_password\"]")).sendKeys("Shivz@123");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[7]/div/div/input")).sendKeys("Shivz@123");
		
		Test.findElement(By.xpath("//*[@name=\"confirm_password\"]")).sendKeys("Shivz@123");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[8]/div/div/input")).sendKeys("Shivz@123");
		
		Test.findElement(By.xpath("//*[@name=\"email\"]")).sendKeys("shivashangari132001@gmail.com");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[9]/div/div/input")).sendKeys("shivashangari@gmail.com");
		
		Test.findElement(By.xpath("//*[@name=\"contact_no\"]")).sendKeys("(638)5300499");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[10]/div/div/input")).sendKeys("(638)5300499");
		
		Test.findElement(By.xpath("//*[@id=\"exampleFormControlTextarea1\"]")).sendKeys("Good");
		//Test.findElement(By.xpath("/html/body/div/form/fieldset/div[11]/div/textarea")).sendKeys("Good");
		
		

		System.out.println(Test.getTitle());
		// Test.close();
	}
}
