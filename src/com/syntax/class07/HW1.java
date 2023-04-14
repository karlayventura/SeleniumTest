package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class HW1 {

    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
        WebDriver driver=new FirefoxDriver();
        driver.get(url);

        String mainPageHandle = driver.getWindowHandle();

        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());

        Iterator<String> it = allWindowHandles.iterator();

        mainPageHandle = it.next(); // take the 1st step & assign the main handle
        String childHandle = it.next();
        driver.switchTo().window(childHandle);
        String title = driver.getTitle();
        System.out.println(title);



    }
}
