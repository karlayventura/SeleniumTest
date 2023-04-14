package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://fb.com");
        // Manually test by going on website/inspect and find element by locator (id)
        driver.findElement(By.id("email")).sendKeys("k.yventura@icloud.com"); // Selenium Interacting with element
        driver.findElement(By.id("pass")).sendKeys("12345");
        driver.findElement(By.name("login")).click();
        Thread.sleep(2000);
        //driver.findElement(By.linkText("Forgot password?")).click();
        driver.findElement(By.partialLinkText("Forgot")).click();
        driver.quit();
    }
}
