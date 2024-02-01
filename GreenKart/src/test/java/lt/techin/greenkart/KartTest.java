package lt.techin.greenkart;

import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class KartTest extends BasePage{

    Kart kart;

    @Test
    void searchFilter(){
        kart = new Kart(driver);
        kart.selectPageSize();
        kart.inputSearch("an");
        List<String> searchResultTexts = kart.searchResult();
        for (String resultText : searchResultTexts) {
            assertTrue(resultText.contains("an"));
        }
    }
    @Test
    void sortAlphabetically(){
        kart = new Kart(driver);
        kart.selectPageSize();
        kart.clickNameHeader();
        List<String> sortedNames = kart.getAfterSorting();
        assertTrue(kart.isSortedAlphabetically(sortedNames));
    }
}
