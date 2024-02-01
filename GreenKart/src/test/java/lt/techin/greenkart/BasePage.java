package lt.techin.greenkart;

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
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    void tearDown(){
        driver.close();
    }
}
