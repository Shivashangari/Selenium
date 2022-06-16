package TestNg;

import org.testng.annotations.Test;

public class TestPrioity {
	@Test(enabled = true)
	public void firstMove() {
		System.out.println("Check on the network");

	}

	@Test(priority=4)
	public void secondMove() {
		System.out.println("Open google Search");

	}

	@Test(priority=2)
	public void thirdMove() {
		System.out.println("Search the content");

	}

	@Test(priority=3)
	public void fourthMove() {
		System.out.println("Click on the link");
	}
//To skip a test case using testNG
	@Test(priority = 4,enabled = false)
	public void fifthMove() {
		System.out.println("copy link");
	}
}
//prority is parameter /atributes which accepct integer value
//@test is a annotation.
