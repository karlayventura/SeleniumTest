package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class HandlingDDWithIterator {

    public static String url = "https://amazon.com";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        WebElement departments = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(departments);
        boolean isMultiple = select.isMultiple();
        System.out.println(isMultiple);

        if (isMultiple){
            List<WebElement> options = select.getOptions();
            Iterator<WebElement> it = options.iterator();
            while (it.hasNext()){
                WebElement ddOption = it.next();
                String optionText = ddOption.getText();
                System.out.println(optionText);
            }

        }


    }
}
