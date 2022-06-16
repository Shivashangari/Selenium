import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
@Test
	public void jaghan() {
	WebDriverManager.chromedriver().setup();
	WebDriver Test = new ChromeDriver();
	Test.get("https://mytestingthoughts.com/Sample/home.html");
	Test.findElement(By.name("first_name")).sendKeys("Shiva");
	Test.findElement(By.name("last_name")).sendKeys("Shangari");
	Test.findElement(By.name("user_name")).sendKeys("Shivashangari");
	Test.findElement(By.name("user_password")).sendKeys("Shivz@123");
	Test.findElement(By.name("confirm_password")).sendKeys("Shivz@123");
	Test.findElement(By.name("email")).sendKeys("shivashangari@gmail.com");
	Test.findElement(By.name("contact_no")).sendKeys("(638)5300499");
	Test.findElement(By.id("exampleFormControlTextarea1")).sendKeys("Good");

	System.out.println(Test.getTitle());
	// Test.close();
	}
}