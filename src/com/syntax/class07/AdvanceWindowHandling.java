package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvanceWindowHandling {

    /*
     * Click on buttons & Open new windows (tabs)
     * Switch to windows & perform different actions
     */

    public static String url = "https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);

        // 1. Get window handle for the main page
        String mainPageHandle = driver.getWindowHandle();

        // 2. Locate elements & Store in WebElement variable
        WebElement igButton = driver.findElement(By.linkText("Follow on Instagram"));
        WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement igAndFbButton = driver.findElement(By.linkText("Follow instagram & Facebook"));

        // 3. Clicking on the 3 elements above
        igButton.click(); // Opens separate window
        fbButton.click(); // Opens separate window
        igAndFbButton.click(); // Opens separate window

        // 4. Store all windows in a set <>
        Set<String> allWindowHandles = driver.getWindowHandles(); // Automatically returns a LinkedHashSet
        System.out.println(allWindowHandles.size()); // 4 different windows

        // 5. Create Iterator to go through set of allWindowsHandles
        Iterator<String> it = allWindowHandles.iterator();
        // 6. Start iterating through the handles
        while (it.hasNext()){
           String handle = it.next(); // Get next handle
            if (!mainPageHandle.equals(handle)){ // set condition
                driver.switchTo().window(handle); // switch to a window that's not equal to main page handle
                String title = driver.getTitle(); // get windows page title
                System.out.println(title); // Prints windows title
                driver.close(); // close child windows
            }
           // 8. Open new window
            driver.switchTo().window(mainPageHandle); // Switch focus back to main window (parent handle)
            igButton.click();

        }
    }
}
