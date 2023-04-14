package com.syntax.class01;

//Imports below from selenium library that we import before class
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
     // 1st selenium WebDriver Script
    public static void main(String[] args) { // 1) Main method

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver"); // 1st our driver, 2nd path/location of chrome driver

        WebDriver driver = new ChromeDriver(); // Launch the browser
        driver.get("https://www.google.com/"); // Navigate to website
        String url = driver.getCurrentUrl();   // Check to see if its same URL as above
        System.out.println(url);               // Print out the URL in the console
        String title = driver.getTitle();      // Get title of the tab of website
        System.out.println(title);             // Print out the title in the console
        driver.quit();                         // Close the browser
    }
}
