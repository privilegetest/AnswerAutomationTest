package herokuappTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import herokuappPages.LoginPage;
import herokuappPages.SecureAreaPage;
import herokuappTests.BaseTests;
import static org.testng.Assert.*;

public class TC001_LoginTests extends BaseTests {
    /************************************************************
     This class tests Login function. Each test sets and assigns login input data,
     asserts if details match details registered to the user on Herokuapp site,
     and displays the result
     ************************************************************/
    /*test to check wrong password+ correct username scenario*/
    @Test
    public void T1testUnsuccessfulLoginpword(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("wrongSecretPassword!");
        loginPage.clickLoginButton();
        String alertText = loginPage.getLoginStatusAlert();
        assertTrue(alertText.contains("Your password is invalid!"),
                "Alert text is incorrect");
    }
        /*checking wrong username+ correct password scenario*/
        @Test
        public void T2testUnsuccessfulLoginuname() {
            LoginPage loginPage = homePage.clickFormAuthentication();
            loginPage.setUsername("WRONGsmith");
            loginPage.setPassword("wrongSecretPassword!");
            loginPage.clickLoginButton();
            String alertText = loginPage.getLoginStatusAlert();
            assertTrue(alertText.contains("Your username is invalid!"),
                    "Alert text is incorrect");
        }

        /*checking wrong username+ wrong password scenario*/
            @Test
            public void T3testUnsuccessfulLogin() {
                LoginPage loginPage = homePage.clickFormAuthentication();
                loginPage.setUsername("wrongtomsmith");
                loginPage.setPassword("wrongSecretPassword!");
                loginPage.clickLoginButton();
                String alertText = loginPage.getLoginStatusAlert();
                assertTrue(alertText.contains("Your username is invalid!"),
                        "Alert text is incorrect");
            }
            /*checking exception scenario- This test fails because button is always enabled,
            * tes included to check failed test results*/
            @Test
            public void T4testUnsuccessfulLoginexception(){
                LoginPage loginPage = homePage.clickFormAuthentication();
                loginPage.setUsername("");
                loginPage.setPassword("");
                loginPage.clickLoginButton();
                assertFalse(loginPage.LoginButtonstate(),
                        "Login button should be disabled");
    }
    @Test
    public void T5testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.navigateToSecureArea();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}

