import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DynamicControls {
    public static final String URL = "http://the-internet.herokuapp.com/dynamic_controls?";
    @Test
    public void DynamicControlsTest()  {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
       WebElement checkbox = driver.findElement(By.tagName("input"));
       checkbox.click();
       WebElement remove = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
       remove.click();
        WebElement message = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
      // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"));
      String text = message.getText();
       assertEquals(text, "It's gone!");



    }
}
//*[@id="checkbox"]/input
//*[@id="checkbox"]
//*[@id="checkbox"]