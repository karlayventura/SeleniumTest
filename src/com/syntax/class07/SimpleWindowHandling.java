package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {

    /*
     * Click on help link
     * Switch between tabs
     */

    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        String mainPageHandle = driver.getWindowHandle(); // Get window handle for the main page
        System.out.println(mainPageHandle);

        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles(); // Store all handle in set
        System.out.println(allWindowHandles.size()); // Return how many tabs are open

        Iterator<String> it = allWindowHandles.iterator(); // Iterator in order to iterate through the handles
        mainPageHandle = it.next(); // take the 1st step & assign the main handle
        String childHandle = it.next(); // take the 2nd step & have a child handle
        System.out.println(childHandle);
        Thread.sleep(2000);
        driver.switchTo().window(childHandle); // Switch to the window you want to close

        driver.close();
        driver.switchTo().window(mainPageHandle);
        helpLink.click();
    }
}
