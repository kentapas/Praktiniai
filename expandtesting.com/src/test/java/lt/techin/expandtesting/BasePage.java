package lt.techin.expandtesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new FirefoxDriver();
        driver.get("https://practice.expandtesting.com/notes/app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @AfterEach
//    void tearDown(){
//        driver.close();
//    }
}
