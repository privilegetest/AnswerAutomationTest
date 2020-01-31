package herokuappTests;
   /************************************************************
This class contains functions common for all tests including setting browser Webdriver,
    and launching home page,
    and closing the browser
     ************************************************************/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import herokuappPages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        /*System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        homePage = new HomePage(driver);*/
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
         /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);*/
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);

    }

   @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
