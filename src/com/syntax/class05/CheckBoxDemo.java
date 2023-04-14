package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxDemo {
    // static string instance variable
    public static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // Locating checkboxes & storing them in list
        List<WebElement> optionCheckBoxes = driver.findElements(By.cssSelector("input[class = 'cb1-element']"));
        int size = optionCheckBoxes.size();
        System.out.println(size);

        // Looping through each element from the list line 20
        for(WebElement option: optionCheckBoxes){
            option.click();
            String checkBoxText = option.getAttribute("value");
            if(checkBoxText.equals("Option-2"));
            option.click();
            break;
        }
    }
}
