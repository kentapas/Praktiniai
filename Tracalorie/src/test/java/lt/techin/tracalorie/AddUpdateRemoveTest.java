package lt.techin.tracalorie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class AddUpdateRemoveTest extends BaseTest{
    private static final Logger log = getLogger(lookup().lookupClass());

    AddUpdateRemove add;

    @Test
    void addItem(){
    add = new AddUpdateRemove(driver);
    add.addItem("egg");
    add.addCalories("50");
    add.clickAddButton();
    log.info("added new item and calories");
    Assertions.assertEquals("egg: 50 Calories", add.assertFirst());
    log.info("asserted that the item was successfully added");
    add.addItem("rice");
    add.addCalories("100");
    add.clickAddButton();
    log.info("added another item and calories");
    Assertions.assertEquals("rice: 100 Calories", add.assertSecond());
    log.info("asserted that the item was successfully added");

    add.clickFirstPencil();
    add.clearItem();
    add.addItem("bread");
    add.clearCalories();
    add.addCalories("30");
    add.clickUpdate();
    log.info("updated the first item and calories");
    Assertions.assertEquals("bread: 30 Calories", add.assertFirst());
    log.info("asserted if the item was updated successfully");

    add.clickFirstPencil();
    add.clickDelete();
    log.info("deleted first item");
    Assertions.assertFalse(add.assertItemDeleted());
    log.info("asserted if the item was deleted successfully");
    }
}
