package com.syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingPaginations {

    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // Implement implicity wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        System.out.println("******* LOGIN ACTION ********");
        // 1. Locate username text box element & store in WebElement variable
        WebElement username = driver.findElement(By.id("txtUsername"));
        // .sendKeys() to add username text
        username.sendKeys("Admin");
        // 2. Locate password text box element & store in WebElement variable
        WebElement password = driver.findElement(By.id("txtPassword"));
        // .sendKeys() to add password text
        password.sendKeys("Hum@nhrm123");
        // 3. Locate login button & store in WebElement variable
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        // .click() to click login button
        loginButton.click();

        System.out.println("******* NAVIGATING TO ADD EMPLOYEE PAGE ********");
        // 4. Locate pim button & store in WebElement variable
        WebElement pimButton = driver.findElement(By.id("menu_pim_viewPimModule"));
        // .click() to click pim button
        pimButton.click();
        // 5.  Locate add employee button & store in WebElement variable
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        // .click() to click add employee button
        addEmployeeButton.click();

        System.out.println("******* ADDING EMPLOYEE AND SAVING ********");
        // 6. Locate firstname text box element & store in WebElement variable
        WebElement firstName = driver.findElement(By.id("firstName"));
        // .sendKeys() to add firstname text
        firstName.sendKeys("Diego");
        // 7. Locate lastname text box element & store in WebElement variable
        WebElement lastName = driver.findElement(By.id("lastName"));
        // .sendKeys() to add lastname text
        lastName.sendKeys("Asghar");
        // 8. Locate employee ID text box element & store in WebElement variable
        WebElement empIdField = driver.findElement(By.id("employeeId"));
        //  get value attribute of employee ID listed & store in string variable
        String empId = empIdField.getAttribute("value");
        // 9. Locate save button & store in WebElement variable
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        // .click() to click save button
        saveButton.click();

        // 10. Locate employee list button & store in WebElement variable
        WebElement employeeList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        // .click() to click employee list button
        employeeList.click();

        System.out.println("***** Pagination Bar *******");
        // 11. Create a boolean condition & while for loop
        boolean flag = true;
        while (flag) {
            // Locate table element & store in a List of WebElements (reinitialize all the elements because the page gets refreshed after each click)
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr"));
            //   We need to loop through each row & get text
            for (int i = 0; i < tableRows.size(); i++) {
                String rowText = tableRows.get(i).getText();
                // if row text contains id value only then set as false
                if (rowText.contains(empId)) {
                    flag = false;
                    // locate checkbox element for employee & click
                    WebElement check = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr[" + i + "]/td[1]"));
                    check.click();
                    // locate delete button & clic
                    WebElement deleteButton = driver.findElement(By.id("btnDelete"));
                    deleteButton.click();
                    // locate web page alert to confirm ok & click
                    WebElement confirmDelete = driver.findElement(By.id("dialogDeleteBtn"));
                    confirmDelete.click();
                    // break after completed
                    break;
                }
            }
            // if condition not met click next button until employee founf & deletes
            if (flag) {
                // Locate Pagination bar "Next" page button & Store in WebElement variable   
                WebElement nextButton = driver.findElement(By.linkText("Next"));
                nextButton.click();
            }
        }

    }
}
