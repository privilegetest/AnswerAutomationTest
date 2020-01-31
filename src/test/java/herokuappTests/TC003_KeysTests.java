package herokuappTests;

/************************************************************
 This class tests user Keyboard actions. Each test assigns keystroke values, including special characters, as the user types,
 and assert if details match what is mirrored back by the Herokuapp site,
 and displays the result
 ************************************************************/

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import herokuappTests.BaseTests;
import java.util.Map;
import static org.testng.Assert.assertEquals;

public class TC003_KeysTests extends BaseTests {
    @Test
    public void T8test1KeyPress(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A");
        assertEquals(keyPage.getResult(), "You entered: A");
    }
    @Test
    public void T9test2KeyPress() {
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A");
        assertEquals(keyPage.getResult(), "You entered: A");
        keyPage.enterText("b");
        assertEquals(keyPage.getResult(), "You entered: B");
    }
    @Test
        public void T10test3KeyPress(){
            var keyPage = homePage.clickKeyPresses();
            keyPage.enterText("A");
            assertEquals(keyPage.getResult(), "You entered: A");
            keyPage.enterText("b");
            assertEquals(keyPage.getResult(), "You entered: B");
            keyPage.enterText("%");
            assertEquals(keyPage.getResult(), "You entered: %");
        }
    @Test
        public void T11test4KeyPress(){
            var keyPage = homePage.clickKeyPresses();
            keyPage.enterText("A");
            assertEquals(keyPage.getResult(), "You entered: A");
            keyPage.enterText("b");
            assertEquals(keyPage.getResult(), "You entered: B");
            keyPage.enterText("%");
            assertEquals(keyPage.getResult(), "You entered: %");
            keyPage.enterText("9");
            assertEquals(keyPage.getResult(), "You entered: 9");
        }

    }
