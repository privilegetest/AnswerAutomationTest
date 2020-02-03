package herokuappTests;

/************************************************************
 This class tests user Keyboard actions. Each test assigns keystroke values, including special characters, as the user types,
 and assert if details match what is mirrored back by the Herokuapp site,
 and displays the result
 ************************************************************/

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;

public class TC003_KeysTests extends BaseTests {
    private SoftAssert softAssert = new SoftAssert();

    @Test
    public void T111testKeyPresses() {
        ArrayList<String> testDataInputArray = new ArrayList<>(Arrays.asList("C", "X", "g", "b"));
        ArrayList<String> testDataResultArray = new ArrayList<>(Arrays.asList());
        var keyPage = homePage.clickKeyPresses();
        for (int arrayIndexLocationInt = 0; arrayIndexLocationInt < testDataInputArray.size(); arrayIndexLocationInt++) {
            keyPage.enterText(testDataInputArray.get(arrayIndexLocationInt));
            keyPage.getResult();
            testDataResultArray.add(arrayIndexLocationInt, keyPage.getResult());
                softAssert.assertEquals(testDataResultArray.get(arrayIndexLocationInt), "You entered: " + testDataInputArray.get(arrayIndexLocationInt), "Input result incorrect for text entry " + testDataInputArray.get(arrayIndexLocationInt));
                System.out.println("case " + arrayIndexLocationInt + " completed");
                softAssert.assertAll();

        }
    }
}