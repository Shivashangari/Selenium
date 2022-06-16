package SampleTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartSort {
	String totalRate;
	static WebDriver link ;
	Properties properties;

	@Test(priority = 0)
	void getpropertyfile() throws IOException {
		String userWorkingDirectory = System.getProperty("user.dir");
		String pathSeparator = System.getProperty("file.separator");
		String filePath = userWorkingDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java"
				+ pathSeparator + "SampleTest" + pathSeparator + "Flipkart.Properties";

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
	void getRating() {
		link.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		link.findElement(By.xpath(properties.getProperty("search"))).sendKeys("Wallet");
		link.findElement(By.xpath(properties.getProperty("submit"))).click();
		String ratingString =link.findElement(By.xpath(properties.getProperty("rating"))).getText();
		System.out.println("Rating is : " + ratingString);

		//To get the rating list of the total  product searched
		List<WebElement> lists=link.findElements(By.xpath(properties.getProperty("totalProduct")));
		List<String> ratingList = new ArrayList<String>();

		for (WebElement webElement : lists) {
		totalRate=webElement.getText();
		System.out.println("Total product Rating is : " + totalRate);
		ratingList.add(totalRate);
		}
//To get them in assending order
		TreeSet<Double> overallRating = new TreeSet<Double>();
		for (String string : ratingList) {
		double totalRating = Double.parseDouble(string);
		overallRating.add(totalRating);

		}
		System.out.println("Highest rating is : " + overallRating.last());
		System.out.println("Lowest rating is : " + overallRating.first());
		}
		
	}


	