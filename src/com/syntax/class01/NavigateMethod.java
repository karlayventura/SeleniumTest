package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); // Set property for WebDriver
        WebDriver driver = new ChromeDriver(); // Launch Browser 1 time
        driver.get("https://www.facebook.com/"); // Opens facebook application
        driver.navigate().to("https://www.google.com/"); // Moves to google applicationd

        driver.navigate().back(); // Goes back to facebook
        driver.navigate().forward(); // Goes to google
        Thread.sleep(2000); // Pause the execution for 2 secs (METHOD NOT RECOMMENDED/Not used at work)
        driver.navigate().refresh(); // Refresh page
        driver.close(); // Will close the current/active tab
        driver.quit();  // Will quit the whole browser
    }
}
