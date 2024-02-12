package lt.techin.tracalorie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class AddUpdateRemoveTest extends BaseTest{
    private static final Logger log = getLogger(lookup().lookupClass());

    AddUpdateRemove add;
    AddUpdateRemove update;
    AddUpdateRemove delete;

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

    update = new AddUpdateRemove(driver);
    update.clickFirstPencil();
    update.clearItem();
    update.addItem("bread");
    update.clearCalories();
    update.addCalories("30");
    update.clickUpdate();
    log.info("updated the first item name and calories");
    Assertions.assertEquals("bread: 30 Calories", update.assertFirst());
    log.info("asserted if the item was updated successfully");

    delete = new AddUpdateRemove(driver);
    delete.clickFirstPencil();
    delete.clickDelete();
    log.info("deleted first item");
    Assertions.assertFalse(delete.assertItemDeleted());
    log.info("asserted if the item was deleted successfully");
    delete.clearAll();
    log.info("cleared the list");
    Assertions.assertEquals("Total Calories: 0", delete.totalCalories());
    log.info("asserted that the list was cleared successfully");
    }
}
