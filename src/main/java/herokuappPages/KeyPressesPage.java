package herokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class KeyPressesPage {
    /************************************************************
     This class acts as interface to KeyPressesPage object,
     and contains elements and methods used to interact with the web elements
     ************************************************************/

    private WebDriver driver;
    private By inputField = By.id("target");
    private By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(inputField).sendKeys(text);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputField, text));
    }

    public void enterText(int arrayIndexLocationInt, ArrayList<String> keyPressesInputArray) {
        enterText(keyPressesInputArray.get(arrayIndexLocationInt));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputField, keyPressesInputArray.get(arrayIndexLocationInt)));
    }
    public String getResult() {
        return driver.findElement(resultText).getText();
    }

    public String getResult(int arrayIndexNumber, ArrayList<String> keyPressesResultArray) {

        keyPressesResultArray.set(arrayIndexNumber,getResult());
        return keyPressesResultArray.get(arrayIndexNumber);
    }

}

