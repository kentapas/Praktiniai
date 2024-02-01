package lt.techin.greenkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kart extends Base{
    public Kart(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#page-menu")
    WebElement dropdownElement;

    @FindBy(css = "#search-field")
    WebElement searchField;

    @FindBy(css = ".table")
    private List<WebElement> searchResults;

    @FindBy(css = "div.products-wrapper table tbody td:first-child")
    private List<WebElement> names;

    @FindBy(css = "tr > th:first-child")
    private WebElement nameHeader;

    public void selectPageSize(){
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(2);
    }
    public void inputSearch(String searchText){
        searchField.sendKeys(searchText);
    }
    public List<String> searchResult() {
        List<String> searchResultTexts = new ArrayList<>();
        for (WebElement result : searchResults) {
            searchResultTexts.add(result.getText());
        }
        return searchResultTexts;
    }
    public void clickNameHeader() {
        nameHeader.click();
    }
    public List<String> getAfterSorting() {
        List<String> namesText = new ArrayList<>();
        for (WebElement element : names) {
            namesText.add(element.getText());
        }
        return namesText;
    }
    public boolean isSortedAlphabetically(List<String> names) {
        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);
        return names.equals(sortedNames);
    }
}
