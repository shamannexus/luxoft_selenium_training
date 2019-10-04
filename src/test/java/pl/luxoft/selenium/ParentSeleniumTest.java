package pl.luxoft.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ParentSeleniumTest {


    protected WebDriver driver;


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
