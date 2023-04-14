package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTablesWithPagination {

    public static String url = "http://practice.syntaxtechs.net/table-pagination-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // 1. Locate WebTables body element  & Store in a list
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'table table-hover']/tbody/tr"));
        // 2. Locate next page button pagination element & Store in a variable
        WebElement nextButton = driver.findElement(By.xpath("//a[@class = 'next_link']"));

        // 3.
        boolean flag = true;

        while (flag) {
            for (WebElement row : rows) {
                String rowText = row.getText();
                if (rowText.contains("Archy J")) {
                    flag = false;
                    System.out.println(rowText);
                    break;
                }
            }
            if(flag){
                nextButton.click();
            }

        }
    }
}