package herokuappPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage<scrollHeightsArray> {
    /************************************************************
     This class acts as interface to InfiniteScrollPage object,
     and contains elements and methods used to interact with the web elements
     ************************************************************/

    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");
    private By lnfiniteScrollText = new By.ByTagName("H3");
    long[] scrollHeightsArray;

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageContentHeader(){
        return driver.findElement(lnfiniteScrollText).getText();
    }

    public void scrollToBottomOfPage(int numScrollsDown) {
        /****This method uses javascript to determine scroll down pages,
         and method accept the number of page scrolls required as input***/
        var jsExecutor = (JavascriptExecutor) driver;
            try {
                long lastHeight = (long) (jsExecutor).executeScript("return document.body.scrollHeight");
                int i = 0;
                while (i<numScrollsDown) {
                    String script = "window.scrollTo(0, document.body.scrollHeight)";
                    (jsExecutor).executeScript(script);
                    Thread.sleep(2000);
                    long newHeight = (long) (jsExecutor).executeScript("return document.body.scrollHeight");
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


    public long returnPreviousScrollHeights(int numScrollsDown) {
        /****This method determines what the previous page height value was,
        and this can be used by a method to navigate one page back up***/
        var jsExecutor = (JavascriptExecutor) driver;
        try {
            long lastHeight = (long) (jsExecutor).executeScript("return document.body.scrollHeight");
            int i = 0;
            scrollHeightsArray = new long[numScrollsDown];
            while (i<numScrollsDown) {
                String script = "window.scrollTo(0, document.body.scrollHeight)";
                (jsExecutor).executeScript(script);
                Thread.sleep(2000);
                long newHeight = (long) (jsExecutor).executeScript("return document.body.scrollHeight");
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
       return scrollHeightsArray[numScrollsDown-1];
    }
    public void ScrollbyPixel(long horizontal,long vertical) {
        var jsExecutor = (JavascriptExecutor) driver;
           jsExecutor.executeScript("window.scrollBy(horizontal,vertical)");
        }
}

