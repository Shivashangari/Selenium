package SampleTest;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAmazon {

	static WebDriver link = null;
	Properties properties = null;
	String browsername = null;

	@Test(priority = 0)
	void getpropertyfile() throws IOException {
		String userWorkingDirectory = System.getProperty("user.dir");
		String pathSeparator = System.getProperty("file.separator");
		String filePath = userWorkingDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java"
				+ pathSeparator + "SampleTest" + pathSeparator + "productDetails.Properties";
		FileInputStream inputStream = new FileInputStream(filePath);
		properties = new Properties();
		properties.load(inputStream);
	}

	@Test(priority = 1)
	void gotowebsite() throws IOException {
		browsername = properties.getProperty("browsername");

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			link = new ChromeDriver();
			link.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			link.get(properties.getProperty("url"));
			link.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.edgedriver().setup();
			link = new EdgeDriver();
			link.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			link.get(properties.getProperty("url"));
			link.manage().window().maximize();
		}
	}

	@Test(priority = 2)
	void searchProduct() {

// search product
		WebElement searchBox = link.findElement(By.id(properties.getProperty("searchbox")));
		searchBox.sendKeys(properties.getProperty("product"));
		link.findElement(By.xpath(properties.getProperty("submitbutton"))).click();
	}

	@SuppressWarnings("rawtypes")
	@Test(priority = 3)
	void getBrand() throws InterruptedException {
		List<WebElement> productsprice = link.findElements(By.cssSelector(properties.getProperty("productprice")));
		Map<WebElement, Integer> map = new HashMap<WebElement, Integer>();

		for (int i = 0; i < productsprice.size(); i++) {
			if (productsprice.get(i).getText() != "") {
				map.put(productsprice.get(i), Integer.parseInt(productsprice.get(i).getText().replaceAll(",", "")));

			}
		}

		System.out.println("Price from high to low ");
		List<Entry<WebElement, Integer>> HighToLowPrice = new ArrayList<Map.Entry<WebElement, Integer>>(map.entrySet());
		HighToLowPrice.sort(Entry.comparingByValue());
		for (Entry Entry : HighToLowPrice) {
			System.out.println(Entry.getValue());
		}
//es.get(es.size()-1).getKey().click();
		HighToLowPrice.get(0).getKey().click();
	
	}
}