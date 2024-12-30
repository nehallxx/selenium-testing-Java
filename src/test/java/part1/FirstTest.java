package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){
//        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterClass
    public void TearDown(){
//        driver.quit();
    }

    @Test
    public void TestLogin() throws InterruptedException{
        Thread.sleep(2000);
        WebElement username= driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        var password=driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);
        String actualRes=driver.findElement(By.tagName("h6")).getText();
        String expectRes="Dashboard";
        Assert.assertEquals(actualRes,expectRes);
    }

}
