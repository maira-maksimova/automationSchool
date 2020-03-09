package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;


public class CtcoSidebar extends BasePage{
    private WebDriver driver;
    private static final By CAREERS_MENU = By.xpath("//a[text()='Careers']");

    public CtcoSidebar(WebDriver driver) {
        this.driver = driver;
        super.waitForElementToBeDisplayed(driver,CAREERS_MENU);
    }

    public CareersMenu hoverCareersMenu() {
        if(driver.findElement(CAREERS_MENU).isDisplayed()) {
            super.hoverOnElement(driver,CAREERS_MENU);
        }
        else {
            throw new ElementNotVisibleException("Element not displayed: " + CAREERS_MENU);
        }

        return new CareersMenu(driver);
    }

    public void clickHome() {

    }

    public void clickNews() {

    }

    public void hoverAboutUs() {

    }

    public void hoverTrainingCentre() {

    }

    public void clickContacts() {

    }

    public void clickLanguage() {

    }
}
