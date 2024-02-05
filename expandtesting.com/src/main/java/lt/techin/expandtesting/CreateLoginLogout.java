package lt.techin.expandtesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateLoginLogout extends Base{
    public CreateLoginLogout(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='btn btn-outline-secondary btn-lg px-4']")
    WebElement createAnAccount;
    @FindBy(css = "input#email")
    WebElement enterEmail;
    @FindBy(css = "input#password")
    WebElement enterPassword;
    @FindBy(css = "input#confirmPassword")
    WebElement enterConfirmPassword;
    @FindBy(css = "input#name")
    WebElement enterName;
    @FindBy(css = ".btn.btn-lg.btn-primary.d-block.w-100")
    WebElement register;
    @FindBy(css = ".alert > b:first-child")
    WebElement success;
    @FindBy(css = ".me-3.text-decoration-none")
    WebElement login;
    @FindBy(css = "input#email")
    WebElement loginEmail;
    @FindBy(css = "input#password")
    WebElement loginPassword;
    @FindBy(css = ".btn.btn-lg.btn-primary.d-block.w-100")
    WebElement clickLogin;
    @FindBy(css = ".btn.btn-outline-danger")
    WebElement logout;
    @FindBy(css = "[class='btn btn-primary btn-lg px-4 me-md-2']")
    WebElement loginExisting;
    public void clickCreateAccount(){
        createAnAccount.click();
    }
    public void inputEmail(String email){
        enterEmail.sendKeys(email);
    }
    public void inputPassword(String password){
        enterPassword.sendKeys(password);
    }
    public void inputConfirmPassword(String confirmPassword){
        enterConfirmPassword.sendKeys(confirmPassword);
    }
    public void inputName(String name){
        enterName.sendKeys(name);
    }
    public void clickRegister(){
        register.click();
    }
    public String assertSuccess(){
        return success.getText();
    }
    public void clickLogin(){
        login.click();
    }
    public void inputLoginEmail(String email){
        loginEmail.sendKeys(email);
    }
    public void inputLoginPassword(String password){
        loginPassword.sendKeys(password);
    }
    public void clickLoginButton(){
        clickLogin.click();
    }
    public void clickLogout(){
        logout.click();
    }
    public boolean logoutIsDisplayed(){
        WebElement logout = driver.findElement(By.cssSelector(".btn-outline-danger"));
        return logout.isDisplayed();
    }
    public void clickLoginExisting(){
        loginExisting.click();
    }
}
