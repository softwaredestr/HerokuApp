import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.testng.Assert.assertEquals;

public class Hovers {
    public static final String URL = "http://the-internet.herokuapp.com/hovers";

    @Test
    public void HoversTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement us1 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/img"));
        WebElement name1 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[1]/div/h5"));
        WebElement link1 = driver.findElement(By.xpath("//*[@href= '/users/1']"));
        action.moveToElement(us1).perform();
        String profile = name1.getText();
        assertEquals(profile, "name: user1");
        action.moveToElement(link1).click().build().perform();
        String text = driver.findElement(By.tagName("h1")).getText();
        assertEquals(text, "Not Found");
        driver.navigate().back();

        WebElement us2 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/img"));
        WebElement name2 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/div/h5"));
        WebElement link2 = driver.findElement(By.xpath("//*[@href= '/users/2']"));
        action.moveToElement(us2).perform();
        String profile2 = name2.getText();
        assertEquals(profile2, "name: user2");
        action.moveToElement(link2).click().build().perform();
        assertEquals(text, "Not Found");
        driver.navigate().back();

        WebElement us3 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[3]/img"));
        WebElement name3 = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[3]/div/h5"));
        WebElement link3 = driver.findElement(By.xpath("//*[@href= '/users/3']"));
        action.moveToElement(us3).perform();
        String profile3 = name3.getText();
        assertEquals(profile3, "name: user3");
        action.moveToElement(link3).click().build().perform();
        assertEquals(text, "Not Found");
        driver.navigate().back();

        driver.quit();
    }
}
