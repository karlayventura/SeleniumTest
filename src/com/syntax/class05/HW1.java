package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

    public static String url = "https://www.facebook.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.findElement(By.linkText("Create new account")).click();

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Karla");
        WebElement lastName = driver.findElement(By.name("lastname"));
        firstName.sendKeys("Ventura");
    }
}
