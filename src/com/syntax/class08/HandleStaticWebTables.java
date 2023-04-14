package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandleStaticWebTables {

    public static String url = "http://practice.syntaxtechs.net/table-search-filter-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        System.out.println("------------- WebTable body Elements --------------------");

        // 1. Locate web table body elements & store in list
        List<WebElement> rowData = driver.findElements(By.xpath("//table[@id = 'task-table']/tbody/tr"));
        System.out.println(rowData.size());

        // 2. Iterate through list of WebElements
        Iterator<WebElement> it = rowData.iterator();

        // 3. while loop - checks condition is true before executing
        while (it.hasNext()){ // .hasNext = returns boolean condition (True or false)
           WebElement row = it.next(); // get next element & store in web element variable
           String rowText = row.getText(); // get text from row variable & store in String variable
            System.out.println(rowText);
        }

        System.out.println("------------- WebTable Header Elements --------------------");

        // 1. Locate Web table header elements & store in list
        List<WebElement> colsData = driver.findElements(By.xpath("//table[@id = 'task-table']/thead/tr/th"));
        System.out.println(colsData.size());

        // 2. for each loop - to loop through each web element
        for (WebElement colData:colsData){
            String colText = colData.getText(); // get text from colData & store in String variable
            System.out.println(colText);
        }

    }
}
