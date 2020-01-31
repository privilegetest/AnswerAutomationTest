package herokuappTests;

import herokuappPages.LoginPage;
import herokuappPages.SecureAreaPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import herokuappTests.BaseTests;
import herokuappPages.HomePage;

public class TC003_LogoutTests extends BaseTests {
    /************************************************************
     This class tests Logout function. The tests asserts if following logout the user is returned to login page
     and the correct alert is displayed on Herokuapp site,
     and displays the result
     ************************************************************/

        /*checking wrong username+ correct password scenario*/
        @Test
        public void T6testLogout() {
            LoginPage loginPage = homePage.clickFormAuthentication();
            loginPage.setUsername("tomsmith");
            loginPage.setPassword("SuperSecretPassword!");
            SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
            LoginPage loginPage2 = secureAreaPage.clickLogoutButton();
            assertTrue(loginPage2.getLoginStatusAlert().contains("You logged into a secure area!"),
                    "Alert text is incorrect");
        }
}
