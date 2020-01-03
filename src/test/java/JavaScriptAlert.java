import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavaScriptAlert {
    public static final String URL = "http://the-internet.herokuapp.com/javascript_alerts";

    @Test
        public void JsAlertTest() throws InterruptedException {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id= 'content']/div/ul/li[3]/button")).click();
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Testim");
        alert.accept();

        String resultText = "You entered: Testim";
        assertEquals (resultText, "You entered: Testim");

        driver.findElement(By.xpath("//*[@id= 'content']/div/ul/li[1]/button")).click();
        String resultText1 = "You successfuly clicked an alert";
        alert.accept();
        assertEquals(resultText1, "You successfuly clicked an alert");

        WebElement jsconfirm = driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button"));
        jsconfirm.click();
        alert.accept();
        String confirmText = "You clicked: Ok";
        assertEquals(confirmText, "You clicked: Ok");
        jsconfirm.click();
        alert.dismiss();
        String confirmText1 = "You clicked: Cancel";
        assertEquals(confirmText1, "You clicked: Cancel");
        Thread.sleep(1000);
        driver.quit();










    }
}
