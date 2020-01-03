import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class ContextMenu {
    public static final String URL = "http://the-internet.herokuapp.com/context_menu";
    @Test
    public void ContextMenuTest()  {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement context = driver.findElement(By.id("hot-spot"));
        action.moveToElement(context).contextClick().build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

}
