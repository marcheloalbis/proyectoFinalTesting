package login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import base.BaseTest;
import pages.SecureAreaPage;

public class LoginTests extends BaseTest{

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(webDriver);
        SecureAreaPage secureAreaPage = loginPage.loginAs("tomsmith","SuperSecretPassword!");
        Assert.assertTrue(secureAreaPage.isSecureAreaPageDisplayed());
        Assert.assertEquals(secureAreaPage.getSecureAreaMessage(), "You logged into a secure area!\n"+"×");
    }

    @Test
    public void testInvalidCredentials(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginAs("someuser","mypassword123");
        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }
}
