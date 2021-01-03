package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {
    //Main Method
    public static void main(String[] args) {
        //Set Path: We will not need to use System.setProperty anymore, because we have maven

        //Step 1: Setting up the WebDriverManage
        WebDriverManager.chromedriver().setup();

        //Step 2: Create Driver
        WebDriver driver=new ChromeDriver();

        //Step 3: Open a website
        driver.get("https://www.google.com");


    }
}
