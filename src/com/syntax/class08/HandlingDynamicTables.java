package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingDynamicTables {

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

        // 1. Locate web table body elements & store in a list
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr"));

        // 2. Create for loop to go through rows list
        for (int i = 0; i < rows.size(); i++){
          String rowText =  rows.get(i).getText();
            System.out.println(rowText);

            if(rowText.contains("Bob Feather")) {
                // 3. Locate checkboxes elements & store in a list
                List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@class = 'SampleTable']/tbody/tr/td[1]"));
               checkBoxes.get(i-1).click();

            }
            }
    }
}
