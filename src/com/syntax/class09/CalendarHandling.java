package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarHandling {

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // Implement implicity wait for web elements
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Login action
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        // Locate leave button element & click
        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();

        // Locate calender element & click
        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();

        // Locate month element drop down
        WebElement monthDD = driver.findElement(By.className("ui-datepicker-month"));
        // Create select class object & store drop down WebElements
        Select select = new Select(monthDD);
        select.selectByVisibleText("Jul");

        // Locate days/date & store in list of web elements
        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));

        // for each Loop to go through the dates
        for (WebElement fromDate:fromDates) {
            String dateText = fromDate.getText();
            if (dateText.equals("4")){
                fromDate.click();
                break;
            }
        }
    }
}
