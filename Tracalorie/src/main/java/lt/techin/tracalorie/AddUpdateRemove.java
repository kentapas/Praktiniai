package lt.techin.tracalorie;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUpdateRemove extends Base{
    public AddUpdateRemove(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#item-name")
    WebElement item;
    @FindBy(css = "#item-calories")
    WebElement calories;
    @FindBy(css = ".add-btn")
    WebElement addButton;
    @FindBy(css = "#item-0")
    WebElement firstItem;
    @FindBy(css = "#item-1")
    WebElement secondItem;
    @FindBy(css = "li#item-0 > .secondary-content")
    WebElement firstPencil;
    @FindBy(css = ".update-btn")
    WebElement update;
    @FindBy(css = ".delete-btn")
    WebElement delete;
    @FindBy(css = ".clear-btn")
    WebElement clear;
    @FindBy(css = ".center-align")
    WebElement total;


    public void addItem (String meal){
        item.sendKeys(meal);
    }
    public void addCalories(String caloriesNumber){
        calories.sendKeys(caloriesNumber);
    }
    public void clickAddButton(){
        addButton.click();
    }
    public String assertFirst(){
        return firstItem.getText();
    }
    public String assertSecond(){
        return secondItem.getText();
    }
    public void clickFirstPencil(){
        firstPencil.click();
    }
    public void clickUpdate(){
        update.click();
    }
    public void clickDelete(){
        delete.click();
    }
    public void clearItem(){
        item.clear();
    }
    public void clearCalories(){
        calories.clear();
    }
    public Boolean assertItemDeleted() {
        try {
            return firstItem.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clearAll (){
        clear.click();
    }
    public String totalCalories(){
        return total.getText();
    }
}
