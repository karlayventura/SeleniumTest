package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0); // switch to frame
        WebElement textbox = driver.findElement(By.id("name")); // textbox inside iframe
        textbox.sendKeys("Batch 12 forever!!!"); // input & send text

        driver.switchTo().defaultContent(); // switch back to main page manually

        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        Alert alert = driver.switchTo().alert(); // switch to alert to click ok
        Thread.sleep(1000);
        alert.accept();

        driver.switchTo().frame("iframe_a"); // switch back to frame using ID
        textbox.click();
        textbox.sendKeys("we are back to frame");

        driver.switchTo().defaultContent();

        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));
        driver.switchTo().frame(frameElement);
        textbox.clear();
        textbox.sendKeys("Hold your horses");

    }
}
