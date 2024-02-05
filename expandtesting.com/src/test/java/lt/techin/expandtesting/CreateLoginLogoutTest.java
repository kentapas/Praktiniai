package lt.techin.expandtesting;

import lt.techin.expandtesting.utils.FailureWatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

@ExtendWith(FailureWatcher.class)
public class CreateLoginLogoutTest extends BaseTest {
    private static final Logger log = getLogger(lookup().lookupClass());

    CreateLoginLogout action;

    @Test
    void CreateAccount(){
        action = new CreateLoginLogout(driver);
        action.clickCreateAccount();
        log.info("Clicked on Create Account");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "https://practice.expandtesting.com/notes/app/register");
        log.info("Asserted that the current url is the correct one");
        action.inputEmail("pobytest123@test.com");
        action.inputName("Poby");
        action.inputPassword("poby123");
        action.inputConfirmPassword("poby123");
        action.clickRegister();
        log.info("Filled all fields with correct info and clicked register");
        Assertions.assertEquals("User account created successfully", action.assertSuccess());
        log.info("Asserted that the account was created successfully");
        action.clickLogin();
        log.info("Clicked login");
        String loginURL = driver.getCurrentUrl();
        Assertions.assertEquals(loginURL, "https://practice.expandtesting.com/notes/app/login");
        log.info("Asserted that the current url is the correct one");
        action.inputLoginEmail("pobytest123@test.com");
        action.inputLoginPassword("poby123");
        action.clickLoginButton();
        log.info("Filled all fields with correct info");
        Assertions.assertTrue(action.logoutIsDisplayed());
        log.info("Asserted that we're logged in");
        action.clickLogout();
        log.info("Clicked logout");
    }
    CreateLoginLogout login;
    @Test
    void LoginWithExistingAccount(){
        login = new CreateLoginLogout(driver);
        login.clickLoginExisting();
        log.info("Clicked on Login");
        String loginURL = driver.getCurrentUrl();
        Assertions.assertEquals(loginURL, "https://practice.expandtesting.com/notes/app/login");
        log.info("Asserted that the current url is the correct one");
        login.inputLoginEmail("pobytest123@test.com");
        login.inputLoginPassword("poby123");
        login.clickLoginButton();
        log.info("Filled all fields with correct info and clicked login");
        Assertions.assertTrue(login.logoutIsDisplayed());
        log.info("Asserted that we're logged in");
        login.clickLogout();
        log.info("Clicked logout");
    }
}
