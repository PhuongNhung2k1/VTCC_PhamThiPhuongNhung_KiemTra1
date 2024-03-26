package com.nhungptp.AutoTestAddToCategory;

import com.nhungptp.common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;
public class AddNewCategory extends BaseTest {


    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://cms.anhtester.com/login");
        Thread.sleep(1000);
        //		Login

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//span[@class='aiz-square-check']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//		Tìm đến category để thực hiện add
        driver.findElement(By.xpath("//span[text()='Products']")).click();
        driver.findElement(By.xpath("//span[text()='Category']")).click();
        driver.findElement(By.xpath("//span[text()='Add New category']")).click();
    }

    @Test
    public void Category_01_EmptyData() throws InterruptedException {
        Thread.sleep(3000);
//		Click button save
        driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Verify vẫn đang ở màn Category Information => chưa add thành công
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Category Information']")).isDisplayed());
        Thread.sleep(3000);
    }

    @Test
    public void Category_02_AddSuccess() throws InterruptedException {
//		Điền Name
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("nhungptp");
        Thread.sleep(1000);
        //click vao dropdown >> chon Sport shoes
        driver.findElement(By.xpath("//div[text()='No Parent']")).click();
        driver.findElement(By.xpath("//li//a//span[text()='Sport shoes']")).click();
        Thread.sleep(1000);
        //chon physical
        driver.findElement(By.xpath("//div[text()='Physical']")).click();
        driver.findElement(By.xpath("//li//a//span[text()='Digital']")).click();
        Thread.sleep(2 * 1000);
        //upload Banner
        driver.findElement(By.xpath("(//label[text()='Banner ']//parent::div//following-sibling::div)[1]//div[text()='Choose File']")).click();
        Thread.sleep(2 * 1000);
        driver.findElement(By.xpath("//div[@title='108608841_p0_master1200.jpg']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[text()='Add Files']")).click();
        Thread.sleep(3 * 1000);
        //upload icon
        driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[2]")).click();
        Thread.sleep(3 * 1000);
        driver.findElement(By.xpath("//div[@title='drink-on-a-plate-with-a-book-behind-it.jpg']//img[@class='img-fit']")).click();
        Thread.sleep(3 * 1000);
        driver.findElement(By.xpath("//button[text()='Add Files']")).click();
        Thread.sleep(3 * 1000);
        //ordering number
        driver.findElement(By.id("order_level")).sendKeys("3");
        Thread.sleep(1000);

        //meta title
        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("Input Meta title");
        Thread.sleep(1000);
        //description
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Input Description");

        Thread.sleep(1000);
        //click vao Filtering Attributes
        driver.findElement(By.xpath("//div[text()='Nothing selected']")).click();
        driver.findElement(By.xpath("//li//a//span[text()='Capacity']")).click();
        Thread.sleep(1000);

//		Click button save
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1000);
//		Verify hiển thị mess tbao thành công
        Assert.assertEquals(driver.findElement(By.xpath("//span[@data-notify='message']")).getText(), "Category has been inserted successfully");
//		Tìm kiếm category vừa tạo thành công
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("nhungptp");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3 * 1000);
//		Verify hiển thì category vừa tạo
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='nhungptp'])[1]")).isDisplayed());
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}