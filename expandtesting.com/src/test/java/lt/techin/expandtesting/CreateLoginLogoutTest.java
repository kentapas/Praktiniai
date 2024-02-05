package lt.techin.expandtesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CreateLoginLogoutTest extends BasePage{
    CreateLoginLogout action;

    @Test
    void CreateAccount(){
        action = new CreateLoginLogout(driver);
        action.clickCreateAccount();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "https://practice.expandtesting.com/notes/app/register");
        action.inputEmail("pobytest123@test.com");
        action.inputName("Poby");
        action.inputPassword("poby123");
        action.inputConfirmPassword("poby123");
        action.clickRegister();
        Assertions.assertEquals("User account created successfully", action.assertSuccess());
        action.clickLogin();
        String loginURL = driver.getCurrentUrl();
        Assertions.assertEquals(loginURL, "https://practice.expandtesting.com/notes/app/login");
        action.inputLoginEmail("pobytest123@test.com");
        action.inputLoginPassword("poby123");
        action.clickLoginButton();
        Assertions.assertTrue(action.logoutIsDisplayed());
        action.clickLogout();
    }
    CreateLoginLogout login;
    @Test
    void LoginWithExistingAccount(){
        login = new CreateLoginLogout(driver);
        login.clickLoginExisting();
        String loginURL = driver.getCurrentUrl();
        Assertions.assertEquals(loginURL, "https://practice.expandtesting.com/notes/app/login");
        login.inputLoginEmail("pobytest123@test.com");
        login.inputLoginPassword("poby123");
        login.clickLoginButton();
        Assertions.assertTrue(login.logoutIsDisplayed());
        login.clickLogout();
    }
}
