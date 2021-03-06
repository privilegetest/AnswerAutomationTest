package herokuappTests;

import herokuappPages.LoginPage;
import herokuappPages.SecureAreaPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class TC003_LogoutTests extends BaseTests {
    /************************************************************
     This class tests Logout function. The tests asserts if following logout the user is returned to login page
     and the correct alert is displayed on Herokuapp site,
     and displays the result
     ************************************************************/
    private String correctUsername ="tomsmith";
    private String correctPassword ="SuperSecretPassword!";

        /*checking wrong username+ correct password scenario*/
        @Test
        public void T6testLogout() {
                LoginPage loginPage = homePage.clickFormAuthentication();
                SecureAreaPage secureAreaPage = loginPage.navigateToSecureArea( correctUsername,correctPassword);
                secureAreaPage.clickLogoutButton();
                String alertText = loginPage.getLoginStatusAlert();
                assertTrue(alertText.contains("You logged into a secure area!"),
                        "Alert text is incorrect");
        }

}
