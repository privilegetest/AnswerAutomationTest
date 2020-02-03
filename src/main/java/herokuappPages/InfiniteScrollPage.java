package herokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage
{
    /************************************************************
     This class acts as interface to InfiniteScrollPage object,
     and contains elements and methods used to interact with the web elements
     ************************************************************/

    private WebDriver driver;
    private By lnfiniteScrollText = By.cssSelector("#content div");
    private Number requiredHeight;
    private Number[] scrollHeightsArray;

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageContentHeader(){
        return driver.findElement(lnfiniteScrollText).getText();
    }

    public void scrollToBottomOfPage(int numScrollsToBottomOfPage) {
        /****This method uses javascript to determine scroll down pages,
         and method accept the number of page scrolls required as input***/

        var jsExecutor = (JavascriptExecutor) driver;
            try {
                Number lastHeight = (Number) (jsExecutor).executeScript("return document.body.scrollHeight");
                int i = 0;
                while (i<numScrollsToBottomOfPage) {
                    String script = "window.scrollTo(0, document.body.scrollHeight)";
                    (jsExecutor).executeScript(script);
                    Thread.sleep(2000);
                    Number newHeight = (Number) (jsExecutor).executeScript("return document.body.scrollHeight");
                    if (newHeight == lastHeight) {
                        break;
                    }
                    lastHeight = newHeight;
                   i= i+1;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    public void scrollToTopofPage() {
        /****This scroll back to top of page***/
        var jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,0)");
    }

    public Number returnRequiredScrollHeight(int numScrollsDown, int numScrollsUp) {
        /****This method determines what the previous page height value was,
        and this can be used by a method to navigate one page back up***/

        var jsExecutor = (JavascriptExecutor) driver;
        try {
            Number lastHeight = (Number) (jsExecutor).executeScript("return document.body.scrollHeight");
            int i = 0;
            scrollHeightsArray = new Number[numScrollsDown];
            while (i<numScrollsDown) {
                String script = "window.scrollTo(0, document.body.scrollHeight)";
                (jsExecutor).executeScript(script);
                Thread.sleep(2000);
                Number newHeight = (Number) (jsExecutor).executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                scrollHeightsArray[i] = lastHeight;
                lastHeight = newHeight;
                i = i + 1;
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requiredHeight = scrollHeightsArray[numScrollsDown-numScrollsUp];
        return  requiredHeight;
    }

    public void scrollBackUp(int numScrollsDown, int numScrollsUp){
        var jsExecutor = (JavascriptExecutor) driver;
        Number requiredHeight = returnRequiredScrollHeight(numScrollsDown,numScrollsUp);
        jsExecutor.executeScript("window.scrollBy(0,arguments[0])",requiredHeight);
    }

}

