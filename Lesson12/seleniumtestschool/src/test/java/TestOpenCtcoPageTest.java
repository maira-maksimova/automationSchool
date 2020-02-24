// Generated by Selenium IDE
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOpenCtcoPageTest {
  private static WebDriver driver;
  private static Map<String, Object> vars;
  static JavascriptExecutor js;

  @BeforeAll
  public static void setUp() {

    System.setProperty("webdriver.gecko.driver", "C:\\srdev\\Tool\\geckodriver.exe");
    //System.setProperty("webdriver.chrome.driver", "C:\\path\\chromedriver.exe");

    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
  @Test
  public void testOpenCtcoPage() {
    driver.get("https://ctco.lv/");
    driver.manage().window().setSize(new Dimension(1248, 691));
    assertEquals(driver.getTitle(), "C.T.Co People");
  }
}