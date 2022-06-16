package SampleTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver link ;
	Properties properties;

	@Test(priority = 0)
	void getpropertyfile() throws IOException {
		String userWorkingDirectory = System.getProperty("user.dir");
		String pathSeparator = System.getProperty("file.separator");
		String filePath = userWorkingDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java"
				+ pathSeparator + "SampleTest" + pathSeparator + "LoginTest.Properties";
		FileInputStream inputStream = new FileInputStream(filePath);
		properties = new Properties();
		properties.load(inputStream);
	}
	@Test(priority = 1)
	void getWebsite() {
		WebDriverManager.chromedriver().setup();
		link = new ChromeDriver();
		link.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		link.get(properties.getProperty("url"));
		link.manage().window().maximize();
	}
	@Test(priority = 2)
	public void getUserDetails() throws IOException {
		link.findElement(By.xpath(properties.getProperty("username"))).sendKeys(properties.getProperty("inputUserName"));
		link.findElement(By.xpath(properties.getProperty("password"))).sendKeys(properties.getProperty("inputPassword"));
		link.findElement(By.xpath(properties.getProperty("submit"))).click();
	}
	@Test(priority=3)
	public void invalidUserName() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) link;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		String Picture = "Invalid";
		File newFile = new File("C:\\Users\\shivashangari.c\\Desktop\\" + Picture + ".jpg");
		org.openqa.selenium.io.FileHandler.copy(file, newFile);
	link.quit();
		}
}
