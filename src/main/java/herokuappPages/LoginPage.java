package herokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    /************************************************************
     This class acts as interface to LoginPage object,
     and contains elements and methods used to interact with the web elements
     ************************************************************/

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");
    private By statusAlert = By.id("flash");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public boolean LoginButtonstate() {
       Boolean buttonstate =  driver.findElement(loginButton).isEnabled();
        return buttonstate;
    }

    public String getLoginStatusAlert() {
        driver.findElement(loginButton).click();
        return driver.findElement(statusAlert).getText();
    }

    /* ----ignore methods not in use yet-----
    public void clearUsername(){
        driver.findElement(passwordField).sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
    }
    public void clearPassword(){
        driver.findElement(passwordField).sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
    }*/

}
