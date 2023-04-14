package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitDemo {

    public static String url = "https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url); //navigates to URL & waits for page to fully load.

        // 1. Create Implicitly Wait = after .get(URL) & ONLY written 1x & Waits for element to be found.
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // (2 inputs)

        WebElement startPracticingButton = driver.findElement(By.id("btn_basic_example"));
        startPracticingButton.click();
    }
}
