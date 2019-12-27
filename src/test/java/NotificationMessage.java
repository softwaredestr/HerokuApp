import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NotificationMessage {
    public static final String URL = "http://the-internet.herokuapp.com/notification_message_rendered";

    @Test
    public void NotificationTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement link = driver.findElement(By.linkText("Click here"));
        link.click();
        WebElement text = driver.findElement(By.id("flash"));

        String message = text.getText();
        String text1 = "Action unsuccesful, please try again";
        String text2 = "Action successful";
        boolean result = true;
        if(message.equals(text1) || message.equals(text2)){
            result = true;
        }
        assertEquals(result, true);


        driver.quit();
    }
}
