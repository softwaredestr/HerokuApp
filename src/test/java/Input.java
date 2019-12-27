import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Input {
    public static final String URL = "http://the-internet.herokuapp.com/inputs";

    @Test
    public void InputTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("23");
        String text = input.getAttribute("value");
        assertEquals(text, "23");
        input.sendKeys(Keys.ARROW_UP);
        text = input.getAttribute("value");
        input.sendKeys(Keys.ARROW_UP);
        text = input.getAttribute("value");
        assertEquals(text, "25");
        input.clear();
        input.sendKeys("11");
        text = input.getAttribute("value");
        assertEquals(text, "11");
        input.clear();


        driver.quit();
    }
}
