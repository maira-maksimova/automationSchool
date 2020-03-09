package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class VacanciesList extends BasePage {
    private WebDriver driver;
    private static final By VACANCIES_LIST = By.cssSelector(".vacancies-menu-block li>a");

    public VacanciesList(WebDriver driver) {
        this.driver = driver;
        super.waitForElementToBeDisplayed(driver, VACANCIES_LIST);
    }

    public VacancyDetails clickOnVacancy(String vacancyName)throws Exception {
        List<WebElement> vacancies = driver.findElements(VACANCIES_LIST);

        WebElement requestedVacancy = vacancies.stream()
                .filter(vacancy -> vacancy.getText().equals(vacancyName))
                .filter(vacancy -> vacancy.isDisplayed())
                .findAny().orElseThrow(NoSuchElementException::new);

        try {
            requestedVacancy.click();
        } catch (Exception e) {
            throw new Exception(String.format("Click on requested vacancy %s link failed: %s", vacancyName, e.getMessage()));
        }

        return new VacancyDetails(driver);
    }
}
