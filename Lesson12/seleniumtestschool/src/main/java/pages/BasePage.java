package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private WebDriver driver;
    private static final int TIMEOUT = 10;


    public void waitForElementToBeDisplayed(WebDriver driver, By by){
        new WebDriverWait(driver, TIMEOUT)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Expected element could not be found: " + by)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void hoverOnElement(WebDriver driver, By by){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
    }

    public boolean isElementPresent(WebDriver driver, By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean result = driver.findElements(locator).size() > 0;
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        return result;
    }

    private WebElement getElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 5)
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Unable to find element located by: " + locator)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
