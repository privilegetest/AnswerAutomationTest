package herokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    /************************************************************
     This class acts as interface to SecureAreaPage object,
     and contains elements and methods used to interact with the web elements
     ************************************************************/

    private WebDriver driver;
    private By statusAlert = By.id("flash");
    private By logoutButton = By.cssSelector("#logout button");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
    public LoginPage clickLogoutButton(){
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }
}
