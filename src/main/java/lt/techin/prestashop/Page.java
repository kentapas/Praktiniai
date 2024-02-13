package lt.techin.prestashop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Page extends Base{
    public Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='products row']//a[contains(text(),'Hummingbird printed t-shirt')]")
    WebElement shirt;
    @FindBy(xpath = "//div[@class='products row']//a[contains(text(),'Hummingbird printed sweater')]")
    WebElement sweater;
    @FindBy(css = ".products.row [alt='Hummingbird printed t-shirt']")
    WebElement clickShirt;
    @FindBy(css = ".products.row [alt='Brown bear printed sweater']")
    WebElement clickSweater;
    @FindBy(css = ".wishlist-button-product")
    WebElement wishlist;
    @FindBy(css = ".modal-text")
    WebElement message;
    @FindBy(css = ".show .btn-secondary")
    WebElement cancel;
    @FindBy(css = "[aria-label='Size']")
    WebElement size;
    @FindBy(css = "[data-button-action]")
    WebElement cart;
    @FindBy(css = "#myModalLabel")
    WebElement added;
    @FindBy(css = ".modal-body .btn.btn-primary")
    WebElement checkout;
    @FindBy(css = "[data-id_customization]")
    WebElement cartItem;
    @FindBy(css = ".size")
    WebElement cartSize;
    @FindBy(css = ".discount-percentage")
    WebElement discount;
    public String assertShirt(){
        return shirt.getText();
    }
    public String assertSweater(){
        return sweater.getText();
    }
    public void clickOnShirt(){
        clickShirt.click();
    }
    public void clickWishlist(){
        wishlist.click();
    }
    public String assertMessage(){
        return message.getText();
    }
    public void clickCancel(){
        cancel.click();
    }
    public void selectSizeXL(){
        Select xl = new Select(size);
        xl.selectByIndex(3);
    }
    public void selectSizeM(){
        Select xl = new Select(size);
        xl.selectByIndex(1);
    }
    public void addCart(){
        cart.click();
    }
    public String assertAdded(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(added));
        return added.getText();
    }
    public void proceedToCheckout(){
        checkout.click();
    }
    public String assertCartItem(){
        return cartItem.getText();
    }
    public String assertSize(){
        return cartSize.getText();
    }
    public String assertDiscount(){
        return discount.getText();
    }
    public void clickOnSweater(){
        clickSweater.click();
    }
}
