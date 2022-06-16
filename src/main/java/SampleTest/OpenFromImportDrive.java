package SampleTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenFromImportDrive {
	@Test
	public void loginTest() {

		System.setProperty("Webdriver.chrome.driver",
				"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://wwww.google.com");

	}

}
