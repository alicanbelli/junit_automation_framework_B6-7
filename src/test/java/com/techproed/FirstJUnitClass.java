package com.techproed;

import org.junit.*;

public class FirstJUnitClass {
    //setUp method runs before each @Test method
    @Before
    public void setUp(){
        System.out.println("This is before method");
    }

    //@Test annotation is to mark a method as test case
    //@Test is used to create a test case
    @Test
    public void test1(){
        System.out.println("This is first test case");
    }
    @Test
    public void test2(){
        System.out.println("This is second test case");
    }

    //@Ignore is used to skip/ignore test cases
    @Ignore
    @Test
    public void test3(){
        System.out.println("This is third test case");
    }

    @Test
    public void test4(){
        System.out.println("This is forth test case");
    }

    //@After runs after each @Test method
    @After
    public void tearDown(){
        System.out.println("This is after method");
    }


    @Test
    public void assertion(){
        //assertTrue(TRUE)=> PASS
        //assertTrue(FALSE)=> FAIL
        Assert.assertTrue("ahmet".contains("a"));//pass
        Assert.assertTrue(6==6);//fails. test case stops here and won't execute the rest

        //assertFalse(TRUE) => FAILS
        //assertFalse(FALSE)=> PASS
        Assert.assertFalse("ahmet".contains("b"));//pass


        //assertEquals("expected","actual"); If expected = actual Then PASS
        //Otherwise FAIL
        Assert.assertEquals("ahmet","ahmet");//pass
        System.out.println("THIS LINE WILL NOT EXECUTE if Previous assertions fails");
    }
}
