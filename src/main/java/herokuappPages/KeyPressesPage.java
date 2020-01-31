package herokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {
    /************************************************************
     This class acts as interface to KeyPressesPage object,
     and contains elements and methods used to interact with the web elements
     ************************************************************/

    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");
    private Actions actions = new Actions((driver));

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(inputField).sendKeys(text);
    }

       public String getResult() {
        return driver.findElement(resultText).getText();
    }


    /*-----ignore methods not in use yet-----
    public void useShiftForUpperCase(){
        driver.findElement(inputField);
        actions.keyDown((WebElement) inputField,Keys.SHIFT).sendKeys("tc").keyUp(Keys.SHIFT);

    }
    public void clearText(){
        driver.findElement(inputField).sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");}

    public void enterPi(){
        driver.findElement(inputField);
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
}*/
}

