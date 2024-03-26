package com.nhungptp.common;


import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    // khoi tao doi tuong driver dung chung
    public WebDriver driver;

    @BeforeClass
    public void createDriver(){

        System.out.println("Đây là before Class");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterClass
    public void CloseDriver(){
        driver.close();
    }
}
