import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSetup {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:\\srdev\\Tool\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ctco.lv");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
