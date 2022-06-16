package Sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOne {
	@Test
	public void openGoogle() {
		long startTime = System.currentTimeMillis();
		System.out.println(startTime);
		WebDriverManager.chromedriver().setup();
		WebDriver webTest = new ChromeDriver();
		webTest.get("https://www.google.com");
		webTest.manage().window().maximize();  //to maximize chrome page
		System.out.println(webTest.getTitle());
		//webTest.quit();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime);

	}

	@Test
	public void openEdge() {
		long edgeStartTime = System.currentTimeMillis();
		System.out.println(edgeStartTime);
		WebDriverManager.edgedriver().setup();
		WebDriver webTest = new EdgeDriver();
		webTest.get("https://www.google.com");
		System.out.println(webTest.getTitle());
		long edgeEndTime = System.currentTimeMillis();
		System.out.println(edgeEndTime);

	}

}
