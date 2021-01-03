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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

//Create a class name : DropDown
//Go to https://the-internet.herokuapp.com/dropdown
//1.Select and Print Option 1 using index
//2.Select and Print Option 2 by value
//3.Select and Print Option 1 value by visible text
//4.Print all dropdown value
//5.Print first selected option
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
    @Test
    public void selectByIndexTest() throws InterruptedException {
        //1. Locate the dropdown element
        WebElement dropdown=driver.findElement(By.id("dropdown"));

        //2. Create Select object and pass dropdown element
        Select options=new Select(dropdown);

        Thread.sleep(5000);
        //3. Now we can use options object to select dropdown element by any of the 3 methods
        options.selectByIndex(1);
    }

    @Test
    public void selectByValueTest() throws InterruptedException {
        //1. Locate the dropdown element
        WebElement dropdown=driver.findElement(By.id("dropdown"));

        //2. Create Select object and pass dropdown element
        Select options=new Select(dropdown);

        Thread.sleep(5000);
        //3. Now we can use options object to select dropdown element by any of the 3 methods
        options.selectByValue("2");// Value of option 2 is 2

    }

    @Test
    public void selectByVisibleTextTest() throws InterruptedException {
        //1. Locate the dropdown element
        WebElement dropdown=driver.findElement(By.id("dropdown"));

        //2. Create Select object and pass dropdown element
        Select options=new Select(dropdown);

        Thread.sleep(5000);
        //3. Now we can use options object to select dropdown element by any of the 3 methods
        options.selectByVisibleText("Option 1");
    }

    @Test
    public void printAllOptions() {
        //1. Locate the dropdown element
        WebElement dropdown=driver.findElement(By.id("dropdown"));

        //2. Create Select object and pass dropdown element
        Select options=new Select(dropdown);

        List<WebElement> allOptions=options.getOptions();

        for (WebElement eachOption:allOptions){
            System.out.println(eachOption.getText());
        }
    }

    @Test
    public void getFirstSelectedOptionTest(){
        //1. Locate the dropdown element
        WebElement dropdown=driver.findElement(By.id("dropdown"));

        //2. Create Select object and pass dropdown element
        Select options=new Select(dropdown);

        //getFirstSelectedOption() return the first selected option.
        String selectedOption=options.getFirstSelectedOption().getText();//Returns the option that is selected.
        System.out.println("Selected Option : "+selectedOption);
    }

    @Test
    public void dropdownSizeTest(){
        //1. Locate the dropdown element
        WebElement dropdown=driver.findElement(By.id("dropdown"));

        //2. Create Select object and pass dropdown element
        Select options=new Select(dropdown);

        int numOfElement=options.getOptions().size();

        //Assert.assertTrue(numOfElement==4);

        Assert.assertEquals("Expected Is Not Equal Actual",4,numOfElement);
        //If Passes==>Only mark the test cases as Passes, and don't show any message
        //If Fails==>Show the message, and mark the test case as Failed
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
