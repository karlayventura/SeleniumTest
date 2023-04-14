package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

    /*
     * Handle each & every alert on the page.
     *
     */

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        WebElement simpleAlertButton = driver.findElement(By.id("alert")); // Identify alert button
        simpleAlertButton.click(); // Click on alert button to see alert pop up
        // Alert is an interface with methods
        Alert simpleAlert = driver.switchTo().alert(); // Create alert obj to Switch focus to alert (We cannot inspect)
        Thread.sleep(2000);
        simpleAlert.accept(); // Handling simple alert - clicks ok


        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();
        Thread.sleep(2000);
        Alert confirmAlert = driver.switchTo().alert(); // switch the focus to alert
        String alertText = confirmAlert.getText(); // .getText() gets alerts text
        System.out.println(alertText);
        confirmAlert.dismiss(); // .dismiss() clicks cancel


        WebElement promptAlertButton = driver.findElement(By.cssSelector("button#prompt"));
        promptAlertButton.click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Batch 12 is the best !!"); // .sendKeys input & sends text
        promptAlert.accept();


    }
}
