import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Dropdown {
    public static final String URL = "http://the-internet.herokuapp.com/dropdown";

    @Test
    public void DropdownTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        String text = select.getFirstSelectedOption().getText();
        assertEquals(text, "Option 1");
        select.selectByVisibleText("Option 2");
        text = select.getFirstSelectedOption().getText();
        assertEquals(text, "Option 2");
        List<WebElement> options = driver.findElements(By.tagName("option"));
        String option = options.get(0).getText();
        String option1 = options.get(1).getText();
        String option2 = options.get(2).getText();
        assertEquals(option, "Please select an option");
        assertEquals(option1, "Option 1");
        assertEquals(option2, "Option 2");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();


    }
}
