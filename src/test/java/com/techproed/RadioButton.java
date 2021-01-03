package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {
//    Create a class : RadioButton
//    Create a method : radioButton
//    Complete the following task
//    Go to https://www.facebook.com/
//    Click on Create an Account button
//    Locate the elements of radio buttons
//    Then click on the radio buttons for your gender if they are not selected
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void radioButton(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.partialLinkText("Create New Account")).click();

        WebElement firstName = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        WebElement lastName = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
        WebElement phone = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
        WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        WebElement gender = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        if(!gender.isSelected()) {
            gender.click();
        }
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        phone.sendKeys(faker.phoneNumber().cellPhone());
        password.sendKeys(faker.lorem().characters(8,16));
    }

    public void tearDown(){
        driver.close();
    }
}
