package com.syntax.class10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakingScreenShot {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.className("button"));
        loginButton.click();

        // 1. Create an object of TakeScreenShot Interface indirectly by downcasting
        TakesScreenshot ts = (TakesScreenshot)driver;
        // 2. Takes screenshot & returns it into a file
        File srcFile = ts.getScreenshotAs(OutputType.FILE); // this method takes a screenshot

        // 3. Copy file -> srcFile & creates a new folder to store the file.
        // Import try & catch
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/SmartBear/adminLogin111.png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}
