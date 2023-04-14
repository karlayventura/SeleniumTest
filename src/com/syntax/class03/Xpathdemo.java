package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        // Create a WebElement variable with find element xpath locator
        WebElement userName = driver.findElement(By.xpath("//input[contains(@id, 'username')]"));
        // input to log in
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type = 'password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value = 'Login']"));
        loginButton.click();

        driver.quit();


    }
}
