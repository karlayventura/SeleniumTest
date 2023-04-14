package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    /*
     * 1. Launch the browser
     * 2. Navigate to amazon website
     * 3. print out the title and the URL in the console
     * 4. close the browser
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");

        WebDriver driver = new ChromeDriver(); // 1. Launch the browser
        driver.get("https://www.amazon.com/"); // 2. Navigate to amazon website
        String url = driver.getCurrentUrl();   // *  Check to see if its same URL as above
        String title = driver.getTitle();      // *  Get title of the tab of website
        System.out.println(title + " " + url); // 3. Print out the title and the URL in the console
        driver.quit();                        //  4. Close the browser




    }
}
