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
        LoginPage loginPage1 = homePage.clickFormAuthentication();
        loginPage1.setUsername("tomsmith");
        loginPage1.setPassword("wrongSecretPassword!");
        String alertText1 = loginPage1.getLoginStatusAlert();
        assertTrue(alertText1.contains("Your password is invalid!"),
                "Alert text is incorrect");
    }
        /*checking wrong username+ correct password scenario*/
        @Test
        public void T2testUnsuccessfulLoginuname() {
            LoginPage loginPage2 = homePage.clickFormAuthentication();
            loginPage2.setUsername("tomsmith");
            loginPage2.setPassword("wrongSecretPassword!");
            String alertText2 = loginPage2.getLoginStatusAlert();
            assertTrue(alertText2.contains("Your username is invalid!"),
                    "Alert text is incorrect");
        }

        /*checking wrong username+ wrong password scenario*/
            @Test
            public void T3testUnsuccessfulLogin() {
                LoginPage loginPage3 = homePage.clickFormAuthentication();
                loginPage3.setUsername("tomsmith");
                loginPage3.setPassword("wrongSecretPassword!");
                String alertText3 = loginPage3.getLoginStatusAlert();
                assertTrue(alertText3.contains("Your username is invalid!"),
                        "Alert text is incorrect");
            }
            /*checking exception scenario*/
            @Test
            public void T4testUnsuccessfulLoginexception(){
                LoginPage loginPage4 = homePage.clickFormAuthentication();
                loginPage4.setUsername("");
                loginPage4.setPassword("");
                loginPage4.clickLoginButton();
                assertFalse(loginPage4.LoginButtonstate(),
                        "Login button should be disabled");
    }
    @Test
    public void T5testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}

