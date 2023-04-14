package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CalendarHandling {

    // Navigating to delta
    // Choosing departure & return dates
    public static String url = "https://www.delta.com/";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // Locate calendar element & store in WebElement variable
        WebElement calendar  = driver.findElement(By.id("input_departureDate_1"));
        calendar.click();

        // Locate next button on calender element & Store in WebElement Variable
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"booking\"]/form/div[1]/div/div[1]/div[1]/div[3]/date-selection-view/div/div/div/div/div[4]/div/div[1]/a[2]/span"));

        // Locate Departure month element on calender & Store in WebElement Variable
        WebElement dMonth = driver.findElement(By.className("dl-datepicker-month-0"));
        String dMonthText = dMonth.getText();

        // While to Loop Through departure Months on calendar
        while (!dMonthText.equals("August")) { // If monthText variable is not equal to august
            nextButton.click();                // click next button until it is equal to august
            dMonthText = dMonth.getText();    // When equal to august Update Month text variable
        }

        // Locate the departure days/dates table body element on calendar & store in a list of WebElements
        List<WebElement> departureDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));

        // for each to loop through departure dates on calendar
        for (WebElement deptDate: departureDates){ // Stores all departure dates & loops through
            if (deptDate.getText().equals("13")){ // if deptDate variable equals 13 than click & break to stop loop
                deptDate.click();
                break;
            }
        }
        // While to Loop Through returning Month element on calendar & Store in WebElement Variable
        WebElement rMonth = driver.findElement(By.className("dl-datepicker-month-1"));
        String rMonthText = rMonth.getText();

        //  While to Loop Through return Months on calendar
        while (!rMonthText.equals("November")){
            nextButton.click();
            rMonthText = rMonth.getText();
        }
         // Locate the return days/dates table body element on calendar & store in a list of WebElements
        List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));

        // for each to loop through return dates on calendar
        for (WebElement returnDate:returnDates ) {
             if (returnDate.getText().equals("30")){
                 returnDate.click();
                 break;
             }
        }
        WebElement doneButton = driver.findElement(By.className("donebutton"));
        doneButton.click();

    }
}
