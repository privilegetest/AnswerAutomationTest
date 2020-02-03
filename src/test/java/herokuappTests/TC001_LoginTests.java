package herokuappTests;


import org.testng.annotations.Test;
import herokuappPages.LoginPage;
import herokuappPages.SecureAreaPage;
import static org.testng.Assert.*;

public class TC001_LoginTests extends BaseTests {
    /************************************************************
     This class tests Login function. Each test sets and assigns login input data,
     asserts if details match details registered to the user on Herokuapp site,
     and displays the result
     ************************************************************/

    private String correctUsername ="tomsmith";
    private String wrongUsername = "WRONGtomsmith";
    private String correctPassword ="SuperSecretPassword!";
    private String wrongPassword = "WRONGSecretPassword!";

    /*test to check wrong password+ correct username scenario*/
    @Test
    public void T1testUnsuccessfulLoginpword(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.loginToSecureArea(correctUsername,wrongPassword);
        assertTrue(loginPage.getLoginStatusAlert().contains("Your password is invalid!"),
                "Alert text is incorrect");
    }
        /*checking wrong username+ correct password scenario*/
        @Test
        public void T2testUnsuccessfulLoginuname() {
            LoginPage loginPage = homePage.clickFormAuthentication();
            String username = wrongUsername;
            String password = correctPassword;
            loginPage.loginToSecureArea(username,password);
            assertTrue(loginPage.getLoginStatusAlert().contains("Your username is invalid!"),
                    "Alert text is incorrect");
        }

        /*checking wrong username+ wrong password scenario*/
            @Test
            public void T3testUnsuccessfulLogin() {
                LoginPage loginPage = homePage.clickFormAuthentication();
                loginPage.loginToSecureArea(wrongUsername,wrongPassword);
                assertTrue(loginPage.getLoginStatusAlert().contains("Your username is invalid!"),
                        "Alert text is incorrect");
            }
            /*checking exception scenario- This test fails because button is always enabled,
            * tes included to check failed test results*/
            @Test
            public void T4testUnsuccessfulLoginexception(){
                LoginPage loginPage = homePage.clickFormAuthentication();
                loginPage.clickLoginButton();
                assertTrue(loginPage.getLoginStatusAlert().contains("Enter username and password!"),
                        "Alert text is incorrect");
    }
    @Test
    public void T5testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        SecureAreaPage secureAreaPage = loginPage.navigateToSecureArea( correctUsername,correctPassword);
        assertTrue(secureAreaPage.getSecureAreaAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}

