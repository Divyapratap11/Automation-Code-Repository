package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.isLoginButtonEnabled(),
                "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskedButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("test123");
        Assert.assertTrue(loginPage.isPasswordMasked(),
                "Password should be masked by default");

        loginPage.togglePasswordVisibility();
        Assert.assertFalse(loginPage.isPasswordMasked(),
                "Password should be visible after clicking eye icon");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("wrongUser");
        loginPage.enterPassword("wrongPass");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Error message should be displayed for invalid credentials");
    }
}
