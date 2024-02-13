package lt.techin.prestashop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;


public class PageTest extends BaseTest{
    private static final Logger log = getLogger(lookup().lookupClass());

    Page page;

    @Test
    void tShirt(){
        page = new Page(driver);
        Assertions.assertEquals("Hummingbird Printed T-Shirt", page.assertShirt());
        log.info("Asserted that the item is displayed with the correct name");
        page.clickOnShirt();
        log.info("Clicked on Hummingbird Printed T-Shirt");
        page.clickWishlist();
        log.info("Clicked on Wishlist icon");
        Assertions.assertEquals("You need to be logged in to save products in your wishlist.", page.assertMessage());
        log.info("Asserted that the correct message is displayed after clicking on the wishlist icon");
        page.clickCancel();
        log.info("Clicked cancel");
        page.selectSizeXL();
        log.info("Changed the size to XL");
        page.addCart();
        log.info("Clicked add to cart");
        String actualMessage = page.assertAdded();
        String expectedMessage = "Product successfully added to your shopping cart";
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
        log.info("Asserted that the product was added to the shopping cart successfully");
        page.proceedToCheckout();
        log.info("Clicked Proceed to checkout");
        Assertions.assertEquals("Hummingbird printed t-shirt", page.assertCartItem());
        log.info("Asserted that the item name in the cart is correct");
        Assertions.assertEquals("Size: XL", page.assertSize());
        log.info("Asserted that the size is correct");
        Assertions.assertEquals("-20%", page.assertDiscount());
        log.info("Asserted that the discount percentage is correct");
    }
    @Test
    void sweater(){
        page = new Page(driver);
        Assertions.assertEquals("Hummingbird Printed Sweater", page.assertSweater());
        log.info("Asserted that the item is displayed with the correct name");
        page.clickOnSweater();
        log.info("Clicked on Hummingbird Printed Sweater");
        page.clickWishlist();
        log.info("Clicked on Wishlist icon");
        Assertions.assertEquals("You need to be logged in to save products in your wishlist.", page.assertMessage());
        log.info("Asserted that the correct message is displayed after clicking on the wishlist icon");
        page.clickCancel();
        log.info("Clicked cancel");
        page.selectSizeM();
        log.info("Changed the size to M");
        page.addCart();
        log.info("Clicked add to cart");
        String actualMessage = page.assertAdded();
        String expectedMessage = "Product successfully added to your shopping cart";
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
        log.info("Asserted that the product was added to the shopping cart successfully");
        page.proceedToCheckout();
        log.info("Clicked Proceed to checkout");
        Assertions.assertEquals("Hummingbird printed sweater", page.assertCartItem());
        log.info("Asserted that the item name in the cart is correct");
        Assertions.assertEquals("Size: M", page.assertSize());
        log.info("Asserted that the size is correct");
        Assertions.assertEquals("-20%", page.assertDiscount());
        log.info("Asserted that the discount percentage is correct");
    }
}
