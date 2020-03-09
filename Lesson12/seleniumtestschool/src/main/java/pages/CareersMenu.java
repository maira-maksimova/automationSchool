package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersMenu extends BasePage {
    private WebDriver driver;

    private static final By VACANCIES_LINK = By.xpath("//a[text()=\"Vacancies\"]");

    public CareersMenu(WebDriver driver) {
        this.driver = driver;
        super.waitForElementToBeDisplayed(driver, VACANCIES_LINK);
    }

    public VacanciesList clickVacancies() throws Exception {
        try {
            driver.findElement(VACANCIES_LINK).click();
        } catch (Exception e){
            throw new Exception("Click on Vacancies link failed: " + e.getMessage());
        }
        return new VacanciesList(driver);
    }
}
