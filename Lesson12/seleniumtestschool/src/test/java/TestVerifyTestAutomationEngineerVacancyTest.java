
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CtcoPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestVerifyTestAutomationEngineerVacancyTest {
    private WebDriver driver;

    CtcoPage ctcoPage;


    @BeforeEach
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:\\srdev\\Tool\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        ctcoPage = new CtcoPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testVerifyTestAutomationEngineerVacancy() {

        ctcoPage.open();
        waitForElementToBeVisibleBy(ctcoPage.careerMenuLocator);


        Actions action = new Actions(driver);
        action.moveToElement(ctcoPage.getCareerMenu()).perform();

        waitForElementToBeVisibleBy(ctcoPage.carrerSubMenuLocator);
        ctcoPage.getVacanciesLink().click();

        waitForElementToBeVisibleBy(ctcoPage.vacanciesListLocator);
        ctcoPage.getTestEngineerLink().click();

        waitForElementToBeVisibleBy(ctcoPage.requiredSkillsLocator);
        assertEquals("Test Automation Engineer", ctcoPage.getVacancyTitle().getText(), "Wrong vacancy present");
        String requiredSkills = ctcoPage.getRequiredSkills().getText();

        assertTrue(requiredSkills.contains("Selenium"), "Expected requirements to contain Selenium but was: " + requiredSkills);
        assertTrue(requiredSkills.contains("communication skills"), "Expected requirements to contain communication skills but was: " + requiredSkills);
        assertTrue(requiredSkills.contains("Good level in English"), "Expected requirements to contain Good level in English but was: " + requiredSkills);

    }

    public void waitForElementToBeVisibleBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
