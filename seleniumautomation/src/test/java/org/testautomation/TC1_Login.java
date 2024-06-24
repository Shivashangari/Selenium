package org.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1_Login {
    public static void main(String[] args) {
        System.out.println("Testcase-1 Check login");
        ChromeDriver driver=new ChromeDriver(); //launching chrome browser
        driver.get("https://practicetestautomation.com/practice-test-login/"); //open the browzer
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,100)","");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        
    }
}
