package com.techproed;


import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaFakerDemo {
    public static void main(String[] args) {
        //Setting up
        WebDriverManager.chromedriver().setup();
        //Creating driver
        WebDriver driver=new ChromeDriver();
        //Putting implicitly wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //maximizing the window
        driver.manage().window().maximize();
        //going to google
        driver.get("https://www.google.com");
        //finding the searchbox element
        WebElement searchBox=driver.findElement(By.name("q"));
        //Creating Faker object to create fake data and use in test cases
        Faker faker=new Faker();
//        System.out.println(faker.name().fullName());
        //Searching for random fullname
        searchBox.sendKeys(faker.name().fullName()+ Keys.ENTER);
        //closing the driver
        driver.quit();

    }
}
