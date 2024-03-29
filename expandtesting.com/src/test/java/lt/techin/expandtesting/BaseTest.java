package lt.techin.expandtesting;

import lt.techin.expandtesting.utils.FailureWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

@ExtendWith(FailureWatcher.class)
public class BaseTest {
    private static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new FirefoxDriver();
        String URL = "https://practice.expandtesting.com/notes/app";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        FailureWatcher.driver = this.driver;
        log.info("Navigated to {}", URL);
    }

    @AfterEach
    void tearDown(){
        driver.close();
        log.info("WebDriver closed");
    }
}
