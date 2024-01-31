package lt.techin.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".oxd-sheet > p:first-child")
    WebElement getUsername;

    @FindBy(css = ".oxd-sheet > p:last-child")
    WebElement getPassword;

    @FindBy(css = "input[name='username']")
    WebElement inputUsername;

    @FindBy(css = "input[name='password']")
    WebElement inputPassword;

    @FindBy(css = ".oxd-button")
    WebElement clickLoginButton;

    @FindBy(css = "li:first-child > .oxd-main-menu-item")
    WebElement admin;

    @FindBy(css = ".oxd-alert-content--error")
    WebElement invalid;
    public String getLoginUsername(){
        String username = getUsername.getText();
        return username.split(":")[1].trim();
    }
    public String getLoginPassword(){
        String password = getPassword.getText();
        return password.split(":")[1].trim();
    }
    public void inputLoginUsername(String username){
        inputUsername.sendKeys(username);
    }
    public void inputLoginPassword(String password){
        inputPassword.sendKeys(password);
    }
    public void clickLogin(){
        clickLoginButton.click();
    }
    public String assertAdmin(){
        return admin.getText();
    }
    public void inputWrongUsername(String username){
        inputUsername.sendKeys(username);
    }
    public void inputWrongPassword(String password){
        inputPassword.sendKeys(password);
    }
    public String assertInvalid(){
        return invalid.getText();
    }
}
