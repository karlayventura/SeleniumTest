package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTask {

    /*
     * Navigate to URL
     * Click on start button
     * Get the text
     * Print out in console
     */
    public static String url = "http://practice.syntaxtechs.net/dynamic-elements-loading.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        // 1. Navigate to URL
        driver.get(url);

        // 2. Locate start button element & store in WebElement variable
        WebElement sButton = driver.findElement(By.id("startButton"));
        // 3. Click on start button
        sButton.click();

        // 4. Create object of WebDriverWait (ExplicitWait)
        WebDriverWait wait = new WebDriverWait(driver, 20); // driver & amount of seconds
        // Wait for expected condition
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), 'Syntax')]")));

        // 5. Get Text & Print = Locate text & store in new WebElement variable
        WebElement welcomeText = driver.findElement(By.xpath("//h4[contains(text(), 'Syntax')]"));
        System.out.println(welcomeText.getText());



    }
}
