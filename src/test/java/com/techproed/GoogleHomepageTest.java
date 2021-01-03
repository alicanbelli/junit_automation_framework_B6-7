package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleHomepageTest {
//    Create a class: GoogleHomepageTest
//    Then create 3 different test methods using the following names. And Go to google
//    gmailLinkTest => Verify if the Gmail link is displayed or not


    //Creating driver at the class level, so it can be used in all of the class methods
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void titleTest(){
        //    titleTest =>Verify if google title = “Google"

        String actualGoogleTitle=driver.getTitle();
        String expectedGoogleTitle="Google";
//        if (actualGoogleTitle.equals(expectedGoogleTitle)){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//        }
        Assert.assertEquals(expectedGoogleTitle,actualGoogleTitle);

    }

    @Test
    public void imageTest(){
        //    imageTest => Verify if google image displays or not
        WebElement googleImage=driver.findElement(By.xpath("//img[@alt='Google']"));
        Assert.assertTrue(googleImage.isDisplayed());
    }

    @Test
    public void gmailLinkTest(){
        WebElement gmailLink = driver.findElement(By.xpath("//a[@class='gb_g']"));
        boolean isTrue=gmailLink.isDisplayed();
        Assert.assertTrue(isTrue);

    }

    //    Close the browser after each test
    @After
    public void tearDown(){
        driver.quit();
    }
}
