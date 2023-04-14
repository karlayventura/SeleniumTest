package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class ExplicitWaitDemo {

    /*
     * Click on get new user
     * get the firstname text
     * printout in console
     */

    public static String url = "https://syntaxprojects.com/dynamic-data-loading-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        WebElement getNewUserButton = driver.findElement(By.id("save"));
        getNewUserButton.click();

        // 1. Create Explicit Wait (WebDriverWait) =
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), 'First Name')]")));

        WebElement firstName = driver.findElement(By.xpath("//p[contains(text(), 'First Name')]"));
        System.out.println(firstName.getText());
    }
}
