package SampleTest;
 
import org.testng.annotations.Test;

public class Test1 {
	@Test(enabled = true)
	public void testOne() {
		System.out.println("Open Amazon");
	}

	@Test(dependsOnMethods = "testOne")
	public void testTwo() {
		System.out.println("login functionalities");
	}

	@Test(dependsOnMethods = "testTwo")
	public void testThree() {
		System.out.println("Check add to cart functionality");
	}
}

