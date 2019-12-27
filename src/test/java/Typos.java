import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Typos {
    public static final String URL = "http://the-internet.herokuapp.com/typos";

    @Test
    public void TyposTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement text = driver.findElement(By.xpath("//*[@id='content']/div/p[2]"));
        String actualResult = text.getText();
        String expectedResult = "Sometimes you'll see a typo, other times you won't.";

        boolean TextCorrect = false;
        if (actualResult.equals(expectedResult)){
            TextCorrect = true;

        }
            assertEquals(TextCorrect, true);
        driver.quit();
    }
}
