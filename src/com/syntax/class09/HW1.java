package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HW1 {

    public static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement checkBox = driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input"));
        checkBox.click();

        WebElement removeButton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
        removeButton.click();

        WebElement text = driver.findElement(By.id("message"));
        String msg = text.getText();
        System.out.println(msg);

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        enableButton.click();
        WebElement isEnable = driver.findElement(By.id("message"));
        String confirmEnable = isEnable.getText();
        System.out.println(confirmEnable);

        WebElement textBox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
        textBox.sendKeys("Hello");

        WebElement disableButton = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
        disableButton.click();

        WebElement isDisable = driver.findElement(By.id("message"));
        String confirmDisable = isDisable.getText();
        System.out.println(confirmDisable);
    }
}
