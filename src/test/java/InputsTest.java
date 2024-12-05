import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class InputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkInputs() {
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[27]/a")).click();
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        WebElement element1 = driver.findElement(By.tagName("input"));
        element1.getAttribute(String.valueOf(1));
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        WebElement element2 = driver.findElement(By.tagName("input"));
        element2.getAttribute(String.valueOf(0));
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        WebElement element3 = driver.findElement(By.tagName("input"));
        element3.getAttribute(String.valueOf(-1));
        driver.findElement(By.tagName("input")).sendKeys("ааа");
        WebElement element4 = driver.findElement(By.tagName("input"));
        element4.getAttribute(String.valueOf(""));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
