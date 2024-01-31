package lt.techin.orangehrm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest{
    LoginPage login;

    @Test
    void correctLogin(){
        login = new LoginPage(driver);
        String username = login.getLoginUsername();
        String password = login.getLoginPassword();
        login.inputLoginUsername(username);
        login.inputLoginPassword(password);
        login.clickLogin();
        String admin = login.assertAdmin();
        Assertions.assertEquals("Admin", admin);
    }
    @Test
    void incorrectLogin(){
        login = new LoginPage(driver);
        login.inputWrongUsername("asd");
        login.inputWrongPassword("123asd");
        login.clickLogin();
        String invalid = login.assertInvalid();
        Assertions.assertEquals("Invalid credentials", invalid);
    }
}
