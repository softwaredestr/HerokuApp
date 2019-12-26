import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElements {
    public static final String URL = "http://the-internet.herokuapp.com/add_remove_elements/";
    public static final String Delete_Button = "//*[text () = 'Delete']";

    @Test
    public void AddRemoveElementsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement addelement = driver.findElement(By.xpath("//*[text () = 'Add Element']"));
        addelement.click();
        List<WebElement> deleteElements = driver.findElements(By.xpath(Delete_Button));
        assertEquals(deleteElements.size(), 1);
        addelement.click();

        deleteElements = driver.findElements(By.xpath(Delete_Button));
        deleteElements.get(1).click();
        assertEquals(deleteElements.size(), 2);
        deleteElements = driver.findElements(By.xpath(Delete_Button));
        assertEquals(deleteElements.size(), 1);

        deleteElements = driver.findElements(By.xpath(Delete_Button));
        deleteElements.get(0).click();


        driver.quit();


    }
}
