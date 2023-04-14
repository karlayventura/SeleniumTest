package com.syntax.class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert {

    public static String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
                        // Add in URL ^ username:password@
                        // Add username & password in the begin of URL

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get(url);
    }
}
