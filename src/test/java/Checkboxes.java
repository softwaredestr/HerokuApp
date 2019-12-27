import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Checkboxes {
    public static final String URL = "http://the-internet.herokuapp.com/checkboxes";

    @Test
    public void CheckboxesTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement check1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement check2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

        boolean checked1 = check1.isSelected();
        boolean checked2 = check2.isSelected();

        assertEquals(checked1, false);
        check1.click();
        checked1 = check1.isSelected();
        assertEquals(checked1, true);

        assertEquals(checked2, true);
        check2.click();
        checked2 = check2.isSelected();
        assertEquals(checked2, false);


        driver.quit();



    }
}
