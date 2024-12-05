import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class AddRemoveElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        List<WebElement> buttons2 = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(2, buttons2.size());
        driver.findElement(By.xpath("//*[@id=\"elements\"]/button[2]")).click();
        List<WebElement> buttons1 = driver.findElements(By.className("added-manually"));
        Assert.assertEquals(1, buttons1.size());
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
